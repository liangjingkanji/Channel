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


val _channel = BroadcastChannel<Bus<Any>>(Channel.BUFFERED)

// <editor-fold desc="发送">

fun send(event: Any, tag: String = "") =
    runBlocking { _channel.send(Bus(event, tag)) }


fun sendTag(tag: String) = runBlocking { _channel.send(Bus(TagEvent(), tag)) }

// </editor-fold>


// <editor-fold desc="接收">

inline fun <reified T> LifecycleOwner.receive(
    active: Boolean = false,
    vararg tags: String = arrayOf(),
    lifecycleEvent: Lifecycle.Event = Lifecycle.Event.ON_DESTROY,
    noinline block: suspend CoroutineScope.(event: T) -> Unit
): ChannelScope {

    val coroutineScope = ChannelScope(this, lifecycleEvent)

    return coroutineScope.launch {
        for (bus in _channel.openSubscription()) {
            if (bus.event is T && (tags.isEmpty() && bus.tag.isBlank() || tags.contains(bus.tag))) {
                if (active) {
                    MutableLiveData<T>().apply {
                        observe(this@receive, Observer {
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


inline fun <reified T> receive(
    vararg tags: String = arrayOf(),
    noinline block: suspend (event: T) -> Unit
): ChannelScope {
    val coroutineScope = ChannelScope()

    return coroutineScope.launch {
        for (bus in _channel.openSubscription()) {
            if (bus.event is T && (tags.isEmpty() && bus.tag.isBlank() || tags.contains(bus.tag))) {
                block(bus.event)
            }
        }
    }
}


fun LifecycleOwner.receiveTag(
    active: Boolean = false,
    vararg tags: String,
    lifecycleEvent: Lifecycle.Event = Lifecycle.Event.ON_DESTROY,
    block: suspend CoroutineScope.(tag: String) -> Unit
): ChannelScope {

    val coroutineScope = ChannelScope(this, lifecycleEvent)

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

fun receiveTag(
    vararg tags: String,
    block: suspend CoroutineScope.(tag: String) -> Unit
): ChannelScope {

    val coroutineScope = ChannelScope()

    return coroutineScope.launch {
        for (bus in _channel.openSubscription()) {
            if (bus.event is TagEvent && tags.contains(bus.tag)) {
                block(bus.tag)
            }
        }
    }
}

// </editor-fold>

