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
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Observer
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.channels.BroadcastChannel
import kotlinx.coroutines.channels.Channel
import kotlinx.coroutines.runBlocking


/**
 * @suppress 一般代码不应该使用
 */
val _channel = BroadcastChannel<_Bus<Any>>(Channel.BUFFERED)

// <editor-fold desc="发送">

/**
 * 发送事件
 * @param event 事件
 * @param tag 标签, 使用默认值空, 则接受者将忽略标签, 仅匹配事件
 */
fun sendEvent(event: Any, tag: String = "") =
    runBlocking { _channel.send(_Bus(event, tag)) }


/**
 * 发送标签
 * @param tag 标签
 */
fun sendTag(tag: String) = runBlocking { _channel.send(_Bus(TagEvent(), tag)) }

// </editor-fold>


//<editor-fold desc="接收事件">

/**
 * 接收事件
 *
 * @param active 当前事件是否仅在处于激活状态[MutableLiveData.onActive]才能被接收到
 * @param tags 可接受零个或多个标签, 如果标签为零个则匹配事件对象即可成功接收, 如果为多个则要求至少匹配一个标签才能成功接收到事件
 * @param lifecycleEvent 自定义生命周期, 默认为销毁时[Lifecycle.Event.ON_DESTROY]注销事件接受者
 * @param block 接收到事件后执行函数
 */
inline fun <reified T> LifecycleOwner.receiveEvent(
    active: Boolean = false,
    vararg tags: String = arrayOf(),
    lifecycleEvent: Lifecycle.Event = Lifecycle.Event.ON_DESTROY,
    noinline block: suspend CoroutineScope.(event: T) -> Unit
): AndroidScope {

    val coroutineScope = AndroidScope(this, lifecycleEvent)

    return coroutineScope.launch {
        for (bus in _channel.openSubscription()) {
            if (bus.event is T && (tags.isEmpty() && bus.tag.isBlank() || tags.contains(bus.tag))) {
                if (active) {
                    MutableLiveData<T>().apply {
                        observe(this@receiveEvent, {
                            coroutineScope.launch {
                                block(it)
                            }
                        })
                        value = bus.event
                    }
                } else block(bus.event)
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
inline fun <reified T> receiveEvent(
    vararg tags: String = arrayOf(),
    noinline block: suspend (event: T) -> Unit
): AndroidScope {
    val coroutineScope = AndroidScope()

    return coroutineScope.launch {
        for (bus in _channel.openSubscription()) {
            if (bus.event is T && (tags.isEmpty() && bus.tag.isBlank() || tags.contains(bus.tag))) {
                block(bus.event)
            }
        }
    }
}
//</editor-fold>


//<editor-fold desc="接收标签">

/**
 * 接收标签, 和[receiveEvent]不同之处在于该函数仅支持标签, 不支持事件+标签
 *
 * @param active 当前事件是否仅在处于激活状态[MutableLiveData.onActive]才能被接收到
 * @param tags 可接受零个或多个标签, 如果标签为零个则匹配事件对象即可成功接收, 如果为多个则要求至少匹配一个标签才能成功接收到事件
 * @param lifecycleEvent 自定义生命周期, 默认为销毁时[Lifecycle.Event.ON_DESTROY]注销事件接受者
 * @param block 接收到事件后执行函数
 */
fun LifecycleOwner.receiveTag(
    active: Boolean = false,
    vararg tags: String,
    lifecycleEvent: Lifecycle.Event = Lifecycle.Event.ON_DESTROY,
    block: suspend CoroutineScope.(tag: String) -> Unit
): AndroidScope {

    val coroutineScope = AndroidScope(this, lifecycleEvent)

    return coroutineScope.launch {
        for (bus in _channel.openSubscription()) {
            if (bus.event is TagEvent && tags.contains(bus.tag)) {
                if (active) {
                    MutableLiveData<String>().apply {
                        observe(this@receiveTag, Observer {
                            coroutineScope.launch {
                                block(it)
                            }
                        })
                        value = bus.tag
                    }
                } else block(bus.tag)
            }
        }
    }

}

/**
 * 接收标签, 和[receiveEvent]不同之处在于该函数仅支持标签, 不支持事件+标签, 此事件要求执行[kotlinx.coroutines.cancel]手动注销
 *
 * @param tags 可接受零个或多个标签, 如果标签为零个则匹配事件对象即可成功接收, 如果为多个则要求至少匹配一个标签才能成功接收到事件
 * @param block 接收到事件后执行函数
 */
fun receiveTag(
    vararg tags: String,
    block: suspend CoroutineScope.(tag: String) -> Unit
): AndroidScope {

    val coroutineScope = AndroidScope()

    return coroutineScope.launch {
        for (bus in _channel.openSubscription()) {
            if (bus.event is TagEvent && tags.contains(bus.tag)) {
                block(bus.tag)
            }
        }
    }
}
//</editor-fold>


