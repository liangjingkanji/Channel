在Channel中我们可以让事件接受者仅在App处于前台时接收事件, 假设在后台就等待其返回前台再执行接收回调.

该场景一般应用于发送事件使全局对话框(全局对话框一般为Activity)弹出, 因为应用处于后台弹出对话框是不符合逻辑的

=== "发送事件"
    ```kotlin
    sendEvent("对话框消息")
    ```

=== "接收事件"
    ```kotlin
    receiveEvent<String>(true) {
        tv_event.text = it
    }
    ```

- 多加个布尔类型参数: true,  既可以开启消息延迟到前台接收的功能
- receiveTag同样支持延迟事件到前台
- 活跃状态: 非`onPause`或者`onDestroy`都属于正在活跃中


<br>

!!! note
    事件延迟到前台接收是使用`LiveData`来实现