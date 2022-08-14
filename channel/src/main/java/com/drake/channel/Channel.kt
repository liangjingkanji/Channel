/*
 * Copyright (C) 2018 Drake, Inc.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

@file:Suppress("ObjectPropertyName", "EXPERIMENTAL_API_USAGE")

package com.drake.channel

import androidx.lifecycle.Lifecycle
import androidx.lifecycle.LifecycleOwner
import androidx.lifecycle.flowWithLifecycle
import androidx.lifecycle.lifecycleScope
import kotlinx.coroutines.CoroutineExceptionHandler
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Job
import kotlinx.coroutines.channels.BufferOverflow
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.filter
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.launch

@PublishedApi
internal var sharedFlow = MutableSharedFlow<ChannelEvent<Any>>(1, onBufferOverflow = BufferOverflow.DROP_OLDEST)
private val channelScope = ChannelScope()


// <editor-fold desc="发送">

/**
 * 发送事件
 * @param event 事件
 * @param tag 标签, 使用默认值空, 则接受者将忽略标签, 仅匹配事件
 */
fun sendEvent(event: Any, tag: String? = null) = channelScope.launch {
    sharedFlow.emit(ChannelEvent(event, tag))
}


/**
 * 发送标签
 * @param tag 标签
 */
fun sendTag(tag: String?) = channelScope.launch {
    sharedFlow.emit(ChannelEvent(ChannelTag, tag))
}

// </editor-fold>


//<editor-fold desc="接收事件">

/**
 * 接收事件
 *
 * @param tags 可接受零个或多个标签, 如果标签为零个则匹配事件对象即可成功接收, 如果为多个则要求至少匹配一个标签才能成功接收到事件
 * @param block 接收到事件后执行函数
 */
inline fun <reified T> LifecycleOwner.receiveEvent(
    vararg tags: String? = emptyArray(),
    lifeEvent: Lifecycle.Event = Lifecycle.Event.ON_DESTROY,
    noinline block: suspend CoroutineScope.(event: T) -> Unit
): Job {
    return ChannelScope(this, lifeEvent).launch {
        sharedFlow.collect {
            if (it.event is T && (tags.isEmpty() || tags.contains(it.tag))) {
                block(it.event)
            }
        }
    }
}

inline fun <reified T> LifecycleOwner.receiveEvent(vararg tags: String? = emptyArray()): Flow<T> {
    return sharedFlow.filter { it.event is T && (tags.isEmpty() || tags.contains(it.tag)) }
        .map { it.event as T }
}

/**
 * 将消息延迟到指定生命周期接收, 默认为前台接受消息
 */
inline fun <reified T> LifecycleOwner.receiveEventLive(
    vararg tags: String? = arrayOf(),
    lifeEvent: Lifecycle.Event = Lifecycle.Event.ON_START,
    repeatOnLifecycle: Boolean = true,
    noinline block: suspend CoroutineScope.(event: T) -> Unit
): Job {
    return lifecycleScope.launch {
        sharedFlow.flowWithLifecycle(lifecycle, lifeEvent.targetState).collect {
            if (it.event is T && (tags.isEmpty() || tags.contains(it.tag))) {
                block(it.event)
            }
        }
    }
}

/**
 * 接收事件, 此事件要求执行[kotlinx.coroutines.cancel]手动注销
 *
 * @param tags 可接受零个或多个标签, 如果标签为零个则匹配事件对象即可成功接收, 如果为多个则要求至少匹配一个标签才能成功接收到事件
 * @param block 接收到事件后执行函数
 */
inline fun <reified T> receiveEventHandler(
    vararg tags: String? = arrayOf(),
    noinline block: suspend CoroutineScope.(event: T) -> Unit
): Job {
    return ChannelScope().launch {
        sharedFlow.collect {
            if (it.event is T && (tags.isEmpty() || tags.contains(it.tag))) {
                block(it.event)
            }
        }
    }
}
//</editor-fold>


//<editor-fold desc="接收标签">


/**
 * 接收标签, 和[receiveEvent]不同之处在于该函数仅支持标签, 不支持事件+标签
 *
 * @param tags 可接受零个或多个标签, 如果标签为零个则匹配事件对象即可成功接收, 如果为多个则要求至少匹配一个标签才能成功接收到事件
 * @param block 接收到事件后执行函数
 */
fun LifecycleOwner.receiveTag(
    vararg tags: String?,
    lifeEvent: Lifecycle.Event = Lifecycle.Event.ON_DESTROY,
    block: suspend CoroutineScope.(tag: String) -> Unit
): Job {
    return ChannelScope(this, lifeEvent).launch(CoroutineExceptionHandler({ coroutineContext, throwable -> })) {
        sharedFlow.collect {
            if (it.event is ChannelTag && !it.tag.isNullOrBlank() && tags.contains(it.tag)) {
                block(it.tag)
            }
        }
    }
}

fun LifecycleOwner.receiveTag(vararg tags: String?): Flow<String> {
    return sharedFlow.filter { it.event is ChannelTag && !it.tag.isNullOrBlank() && tags.contains(it.tag) }
        .map { it.tag!! }
}

/**
 * 将消息延迟到指定生命周期接收, 默认为前台接受消息
 */
fun LifecycleOwner.receiveTagLive(
    vararg tags: String?,
    lifeEvent: Lifecycle.State = Lifecycle.State.STARTED,
    repeatOnLifecycle: Boolean = true,
    block: suspend CoroutineScope.(tag: String) -> Unit
): Job {
    return lifecycleScope.launch {
        sharedFlow.flowWithLifecycle(lifecycle, lifeEvent).collect {
            if (it.event is ChannelTag && !it.tag.isNullOrBlank() && tags.contains(it.tag)) {
                block(it.tag)
            }
        }
    }
}

fun getLifeState(event: Lifecycle.Event): Lifecycle.State {
    return when (event) {
        Lifecycle.Event.ON_CREATE -> Lifecycle.State.CREATED
        Lifecycle.Event.ON_START -> Lifecycle.State.CREATED
        Lifecycle.Event.ON_RESUME -> Lifecycle.State.CREATED
        Lifecycle.Event.ON_PAUSE -> Lifecycle.State.RESUMED
        Lifecycle.Event.ON_STOP -> Lifecycle.State.STARTED
        Lifecycle.Event.ON_DESTROY -> Lifecycle.State.CREATED
        Lifecycle.Event.ON_ANY -> Lifecycle.State.CREATED
    }
}

/**
 * 接收标签, 和[receiveEvent]不同之处在于该函数仅支持标签, 不支持事件+标签, 此事件要求执行[kotlinx.coroutines.cancel]手动注销
 *
 * @param tags 可接受零个或多个标签, 如果标签为零个则匹配事件对象即可成功接收, 如果为多个则要求至少匹配一个标签才能成功接收到事件
 * @param block 接收到事件后执行函数
 */
fun receiveTagHandler(
    vararg tags: String?,
    block: suspend CoroutineScope.(tag: String) -> Unit
): Job {
    return ChannelScope().launch {
        sharedFlow.collect {
            if (it.event is ChannelTag && !it.tag.isNullOrEmpty() && tags.contains(it.tag)) {
                block(it.tag)
            }
        }
    }
}
//</editor-fold>


