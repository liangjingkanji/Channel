[channel](../../index.md) / [com.drake.channel](../index.md) / [androidx.lifecycle.LifecycleOwner](index.md) / [receiveEventLive](./receive-event-live.md)

# receiveEventLive

`inline fun <reified T> LifecycleOwner.receiveEventLive(vararg tags: `[`String`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)` = arrayOf(), noinline block: suspend CoroutineScope.(event: T) -> `[`Unit`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html)`): Job`

使用LiveData将消息延迟到前台接收

