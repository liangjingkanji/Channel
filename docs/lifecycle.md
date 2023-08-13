`Channel.receiveEvent`支持`自动注销`, 当然也支持手动注销

## 指定取消生命周期

默认在`Lifecycle.Event.ON_DESTROY`销毁, 但是可以指定其参数

```kotlin
receiveEvent<String>(lifeEvent = Lifecycle.Event.ON_PAUSE) {
    tv.text = it
}
```

## 手动注销

使用`receiveEventHandler`可返回用于手动取消事件的对象

```kotlin
val receiver = receiveEventHandler<String> {
    tv.text = it
}

receiver.cancel() // 手动调用函数注销
```