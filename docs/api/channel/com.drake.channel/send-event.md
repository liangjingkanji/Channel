[channel](../index.md) / [com.drake.channel](index.md) / [sendEvent](./send-event.md)

# sendEvent

`fun sendEvent(event: `[`Any`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-any/index.html)`, tag: `[`String`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)` = ""): suspend () -> `[`Unit`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html)

发送事件

### Parameters

`event` - 事件

`tag` - 标签, 使用默认值空, 则接受者将忽略标签, 仅匹配事件