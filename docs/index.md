事件的发送和接收可以在项目中的任何地方

这里我使用字符串作为一个事件对象,当然你创建一个任意对象或者使用`Int`都可以
<br>

> `receiveEvent` 只有在Fragment/Activity或者任何继承`LifecycleOwner`的类中调用才会自动取消 <br>
> 否则需要手动取消, 请查看目录[生命周期](lifecycle.md)一章, 不取消接受会导致重复收到事件


=== "发送事件"
    ```kotlin
    sendEvent("发送事件给当前")
    ```

=== "接收事件"
    ```kotlin
    receiveEvent<String>() {
        tv_event.text = it
    }
    ```

<br>

> 只要`sendEvent`的参数类型和`receiveEvent`的泛型类型匹配即可成功收发事件, 可以是任何对象(包括布尔类型或者字符串)

## 标签
有时候事件类型可能出现重叠或者叫复用, 我们可以通过加标签来区分事件

创建一个对象作为事件
```kotlin
data class MyEvent(val name:String, val age:Int)
```

=== "发送事件"
    ```kotlin
    sendEvent(MyEvent("吴彦祖", 24), "sexy_man_tag")
    ```

=== "接收事件"
    ```kotlin
    receiveEvent<MyEvent>("sexy_man_tag") {
        tv_event.text = it.name // it 即为MyEvent对象
    }
    ```


- 接受者传入的标签可以是多个, 但是发送了标签就一定要和接受者匹配至少一个标签, 否则无法成功接收到事件
- 标签命名建议遵守规范, 例如`tag_refresh`, 全部有个前缀`tag_`, 方便你到时候全局搜索标签来定位事件

## 粘性事件

本框架不支持粘性事件, 因为粘性事件本质就是全局变量, 而全局变量会在应用意外销毁时被清除会导致不可预见的空指针行为.

我建议使用本地序列化的数据替代. 推荐使用[Serialize](https://github.com/liangjingkanji/Serialize)创建自动映射到本地磁盘的字段