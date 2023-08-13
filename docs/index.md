可以在任何地方发送和接收任何对象

=== "发送"
    ```kotlin
    sendEvent("任何对象")
    ```

=== "接收"
    ```kotlin
    receiveEvent<String>() {
        tv.text = it
    }
    ```

!!! success "事件匹配"
    `sendEvent`的参数和`receiveEvent`的泛型类型匹配即可接受事件, 可以是任何对象

## 标签
如果类型重复, 可以通过加标签来区分事件

创建一个事件类
```kotlin
data class UserInfoEvent(val name:String, val age:Int)
```

=== "发送"
    ```kotlin
    sendEvent(UserInfoEvent("新的姓名", 24), "tag_change_name")
    ```

=== "接收"
    ```kotlin
    receiveEvent<UserInfoEvent>("tag_change_name", "tag_change_username") {
        tv.text = it.name // it 即为UserInfoEvent
    }
    ```


- 标签可以是多个, 只要匹配一个标签, 就可成功接收事件
- 建议遵守前缀`tag_`命名规范, 方便全局搜索标签来定位事件

<br>
!!! failure "不支持粘性事件"
    因为粘性事件本质属于全局变量, 会在应用意外销毁时被清除, 导致空指针

    建议使用 [Serialize](https://github.com/liangjingkanji/Serialize) 创建序列化字段, 读写自动映射磁盘