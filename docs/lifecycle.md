基本上所有的事件分发框架都需要手动注销接受者, 但是Channel默认支持`自动注销`(当然也支持手动注销)

只要在Activity或者Fragment中使用`receiveEvent/receiveTag`其接受者就会在Activity或者Fragment被销毁的时候默认注销掉

<br>
配置自动注销的生命周期
```kotlin
receiveEvent<String>(lifecycleEvent = Lifecycle.Event.ON_PAUSE) {
    tv_event.text = it
}
```


手动注销
```kotlin
val scope = receiveEvent<String> {
    tv_event.text = it
}

scope.cancel() // 手动调用函数注销
```