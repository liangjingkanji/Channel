[channel](../index.md) / [com.drake.channel](./index.md)

## Package com.drake.channel

### Extensions for External Classes

| Name | Summary |
|---|---|
| [androidx.lifecycle.LifecycleOwner](androidx.lifecycle.-lifecycle-owner/index.md) |  |

### Functions

| Name | Summary |
|---|---|
| [receiveEventHandler](receive-event-handler.md) | 接收事件, 此事件要求执行[kotlinx.coroutines.cancel](#)手动注销`fun <T> receiveEventHandler(vararg tags: `[`String`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)` = arrayOf(), block: suspend CoroutineScope.(event: T) -> `[`Unit`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html)`): Job` |
| [receiveTagHandler](receive-tag-handler.md) | 接收标签, 和[receiveEvent](androidx.lifecycle.-lifecycle-owner/receive-event.md)不同之处在于该函数仅支持标签, 不支持事件+标签, 此事件要求执行[kotlinx.coroutines.cancel](#)手动注销`fun receiveTagHandler(vararg tags: `[`String`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)`, block: suspend CoroutineScope.(tag: `[`String`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)`) -> `[`Unit`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html)`): Job` |
| [sendEvent](send-event.md) | 发送事件`fun sendEvent(event: `[`Any`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-any/index.html)`, tag: `[`String`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)` = ""): suspend () -> `[`Unit`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html) |
| [sendTag](send-tag.md) | 发送标签`fun sendTag(tag: `[`String`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)`): suspend () -> `[`Unit`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html) |
