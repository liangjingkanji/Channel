[channel](../../index.md) / [com.drake.channel](../index.md) / [androidx.lifecycle.LifecycleOwner](index.md) / [receiveTag](./receive-tag.md)

# receiveTag

`fun LifecycleOwner.receiveTag(vararg tags: `[`String`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)`?, block: suspend CoroutineScope.(tag: `[`String`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)`) -> `[`Unit`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html)`): Job`

接收标签, 和[receiveEvent](receive-event.md)不同之处在于该函数仅支持标签, 不支持事件+标签

### Parameters

`active` - 当前事件是否仅在处于激活状态[MutableLiveData.onActive](#)才能被接收到

`tags` - 可接受零个或多个标签, 如果标签为零个则匹配事件对象即可成功接收, 如果为多个则要求至少匹配一个标签才能成功接收到事件

`block` - 接收到事件后执行函数