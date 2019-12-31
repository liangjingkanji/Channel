package com.drake.channel.exmple

import androidx.lifecycle.Lifecycle
import androidx.lifecycle.LifecycleOwner
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.channels.Channel


val channel = Channel<Any>()


fun sendEvent(event: Any, tag: String = "") {

}

fun sendTag(tag: String) {

}

inline fun <reified T> LifecycleOwner.observeEvent(
    vararg tags: String = arrayOf(),
    dispatcher: CoroutineDispatcher = Dispatchers.Main,
    lifecycleEvent: Lifecycle.Event = Lifecycle.Event.ON_DESTROY,
    noinline block: () -> Unit
) {

}

fun LifecycleOwner.observeTag(
    vararg tags: String,
    dispatcher: CoroutineDispatcher = Dispatchers.Main,
    lifecycleEvent: Lifecycle.Event = Lifecycle.Event.ON_DESTROY,
    block: String.() -> Unit
) {

}

