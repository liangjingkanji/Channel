- 发送事件可以在任何线程
- 接收事件可以在任何线程, 但成功回调默认在主线程

<br>
我们可以通过协程的一系列函数切换其内部线程(在协程中被称为调度器)

```kotlin
receiveEvent<String> {
    // 当前处于主线程
    tv_event.text = it

    launch(Dispatchers.IO) {
        // 执行一个异步任务
    }
}
```

具备返回值回调的切换
```kotlin
receiveEvent<String> {
    // 当前处于主线程
    tv_event.text = withContext(Dispatchers.IO){
        // 切换到IO线程然后返回一个结果["吴彦祖"]到主线程
        "吴彦祖"
    }
}
```