使用`receiveEventLive`指定仅在App前台时接收事件, 如果后台就延迟到前台时接收

=== "发送"
    ```kotlin
    sendEvent("对话框消息")
    ```

=== "接收"
    ```kotlin
    receiveEventLive<String>(true) {
        tv.text = it
    }
    ```

!!! note "活跃状态"
    非`onPause`或者`onDestroy`都属于正在活跃中