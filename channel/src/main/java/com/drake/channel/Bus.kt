package com.drake.channel

class Bus<T>(val event: T, val tag: String = "") {

    override fun toString(): String {
        return "event = $event, tag = $tag"
    }
}