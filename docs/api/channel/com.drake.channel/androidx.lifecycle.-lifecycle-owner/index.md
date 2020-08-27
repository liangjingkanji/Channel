[channel](../../index.md) / [com.drake.channel](../index.md) / [androidx.lifecycle.LifecycleOwner](./index.md)

### Extensions for androidx.lifecycle.LifecycleOwner

| Name | Summary |
|---|---|
| [receiveEvent](receive-event.md) | 接收事件`fun <T> LifecycleOwner.receiveEvent(active: `[`Boolean`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-boolean/index.html)` = false, vararg tags: `[`String`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)` = arrayOf(), lifecycleEvent: Event = Lifecycle.Event.ON_DESTROY, block: suspend CoroutineScope.(event: T) -> `[`Unit`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html)`): AndroidScope` |
| [receiveTag](receive-tag.md) | 接收标签, 和[receiveEvent](receive-event.md)不同之处在于该函数仅支持标签, 不支持事件+标签`fun LifecycleOwner.receiveTag(active: `[`Boolean`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-boolean/index.html)` = false, vararg tags: `[`String`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)`, lifecycleEvent: Event = Lifecycle.Event.ON_DESTROY, block: suspend CoroutineScope.(tag: `[`String`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)`) -> `[`Unit`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html)`): AndroidScope` |
