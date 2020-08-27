有时候我们常常仅需要发送一个用于通知的事件(或者简单的字符串), 这个时候去创建一个类来表示事件就显得很多余. 所以这里我们可以仅发送`标签`

=== "发送标签"
    ```kotlin
    sendTag("refresh_tag")
    ```

=== "接收标签"
    ```kotlin
    receiveTag("refresh_tag") {
        Log.d("日志", "收到标签 $it")
    }
    ```

<br>

!!! note
    其他基础类型也可以通过字符串表示, 然后使用`toInt/toBoolean`等函数转为基础类型