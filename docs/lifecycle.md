基本上所有的事件分发框架都需要手动注销接受者, 但是Channel默认支持`自动注销`(当然也支持手动注销)

只要在Activity或者Fragment中使用`receiveEvent/receiveTag`其接受者就会在Activity或者Fragment被销毁的时候默认注销掉

## 指定取消生命周期

默认在`Lifecycle.Event.ON_DESTROY`销毁, 但是可以指定其参数

```kotlin
receiveEvent<String>(lifeEvent = Lifecycle.Event.ON_PAUSE) {
    tv_event.text = it
}
```

## 手动注销

当不需要自动注销情况下可以使用`receiveEventHandler`返回一个Job用于手动取消事件接收者

```kotlin
val job = receiveEventHandler<String> {
    tv_event.text = it
}

job.cancel() // 手动调用函数注销
```