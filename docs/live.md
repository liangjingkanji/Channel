在Channel中我们可以让事件接受者仅在App处于前台时接收事件, 假设在后台就延迟到返回前台时接收事件.

> 即为`LiveData`特性, 仅在前台接受事件

使用`live`后缀的`receiveEvent`函数即可

=== "发送事件"
    ```kotlin
    sendEvent("对话框消息")
    ```

=== "接收事件"
    ```kotlin
    receiveEventLive<String>(true) {
        tv_event.text = it
    }
    ```

- 活跃状态: 非`onPause`或者`onDestroy`都属于正在活跃中


<br>

> 事件延迟到前台接收是使用`LiveData`来实现