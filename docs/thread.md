- 可以在任何线程发送事件
- 可以在任何线程接收事件, 回调永远在主线程

<br>
使用协程函数可以切换回调的线程(也被称为调度器)

```kotlin
receiveEvent<String> {
    // 当前主线程
    tv.text = it

    launch(Dispatchers.IO) {
        // 执行异步任务
    }
}
```

具备返回值回调的切换
```kotlin
receiveEvent<String> {
    // 当前主线程
    tv.text = withContext(Dispatchers.IO){
        // 切换到IO线程, 返回结果到主线程
        "新的姓名"
    }
}
```