有时候我们常常仅需要发送一个用于通知的事件(或者简单的字符串), 这个时候去创建一个类来表示事件就显得很多余. 所以这里我们可以仅发送`标签`

=== "发送标签"
    ```kotlin
    sendTag("tag_refresh")
    ```

=== "接收标签"
    ```kotlin
    // 单个标签
    receiveTag("tag_refresh") {
        Log.d("日志", "收到标签 $it")
    }

    // 多个标签
    receiveTag("tag_user_info", "tag_logout") {
        Log.d("日志", "收到标签 $it")
    }
    ```

<br>
