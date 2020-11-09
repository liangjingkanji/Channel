[channel](../../index.md) / [com.drake.channel](../index.md) / [androidx.lifecycle.LifecycleOwner](index.md) / [receiveEvent](./receive-event.md)

# receiveEvent

`inline fun <reified T> LifecycleOwner.receiveEvent(vararg tags: `[`String`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)` = arrayOf(), noinline block: suspend CoroutineScope.(event: T) -> `[`Unit`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html)`): Job`

接收事件

### Parameters

`tags` - 可接受零个或多个标签, 如果标签为零个则匹配事件对象即可成功接收, 如果为多个则要求至少匹配一个标签才能成功接收到事件

`block` - 接收到事件后执行函数