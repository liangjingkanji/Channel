[channel](../../index.md) / [com.drake.channel](../index.md) / [androidx.lifecycle.LifecycleOwner](./index.md)

### Extensions for androidx.lifecycle.LifecycleOwner

| Name | Summary |
|---|---|
| [receiveEvent](receive-event.md) | 接收事件`fun <T> LifecycleOwner.receiveEvent(vararg tags: `[`String`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)` = arrayOf(), block: suspend CoroutineScope.(event: T) -> `[`Unit`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html)`): Job` |
| [receiveEventLive](receive-event-live.md) | 使用LiveData将消息延迟到前台接收`fun <T> LifecycleOwner.receiveEventLive(vararg tags: `[`String`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)` = arrayOf(), block: suspend CoroutineScope.(event: T) -> `[`Unit`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html)`): Job` |
| [receiveTag](receive-tag.md) | 接收标签, 和[receiveEvent](receive-event.md)不同之处在于该函数仅支持标签, 不支持事件+标签`fun LifecycleOwner.receiveTag(vararg tags: `[`String`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)`?, block: suspend CoroutineScope.(tag: `[`String`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)`) -> `[`Unit`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html)`): Job` |
| [receiveTagLive](receive-tag-live.md) | 使用LiveData将消息延迟到前台接收`fun LifecycleOwner.receiveTagLive(vararg tags: `[`String`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)`, block: suspend CoroutineScope.(tag: `[`String`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)`) -> `[`Unit`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html)`): Job` |
