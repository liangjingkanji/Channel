package com.drake.channel


/**
 * Channel承载事件的模型
 * @suppress 内部函数, 不应当在一般代码中使用
 */
@Suppress("ClassName")
class _Bus<T>(val event: T, val tag: String = "") {

    override fun toString(): String {
        return "event = $event, tag = $tag"
    }
}