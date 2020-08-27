Channel可以捕获接收事件的作用域内的所有异常

```kotlin
receiveEvent<String> {
    tv_event.text = it // 该大括号内即为接收事件的作用域
}.catch {
    // 当接收事件的作用域内发生异常会回调此处, it即为该异常对象
}.finally {
    // 当内部处理完成即执行此处, it为异常, 如果没有发生则为Null
}
```