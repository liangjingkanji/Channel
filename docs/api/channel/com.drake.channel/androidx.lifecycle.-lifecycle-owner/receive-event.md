[channel](../../index.md) / [com.drake.channel](../index.md) / [androidx.lifecycle.LifecycleOwner](index.md) / [receiveEvent](./receive-event.md)

# receiveEvent

`inline fun <reified T> LifecycleOwner.receiveEvent(active: `[`Boolean`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-boolean/index.html)` = false, vararg tags: `[`String`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)` = arrayOf(), lifecycleEvent: Event = Lifecycle.Event.ON_DESTROY, noinline block: suspend CoroutineScope.(event: T) -> `[`Unit`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html)`): AndroidScope`

接收事件

### Parameters

`active` - 当前事件是否仅在处于激活状态[MutableLiveData.onActive](#)才能被接收到

`tags` - 可接受零个或多个标签, 如果标签为零个则匹配事件对象即可成功接收, 如果为多个则要求至少匹配一个标签才能成功接收到事件

`lifecycleEvent` - 自定义生命周期, 默认为销毁时[Lifecycle.Event.ON_DESTROY](#)注销事件接受者

`block` - 接收到事件后执行函数