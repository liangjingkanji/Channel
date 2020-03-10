内部使用协程实现的Android事件总线框架

用于替换同类型框架: RxBus/EventBus/LiveDataBus

## 特性

1. 发送消息 + 标签
2. 仅发送标签
3. 自动注销
4. 自定义注销的生命周期, 手动取消观察者
5. 接收消息属于异步主线程作用域
6. 捕捉异常
7. 回调 catch/finaly
8. 消息延迟到应用前台时接收



## 依赖

## 安装

project 的 build.gradle

```groovy
allprojects {
    repositories {
        // ...
        maven { url 'https://jitpack.io' }
    }
}
```



module 的 build.gradle

```groovy
implementation 'com.github.liangjingkanji:Channel:1.0.1'
```

## 示例



```kotlin
sendEvent("吴彦祖")

receiveEvent<String> {
  Log.d("日志", "(MainActivity.kt:25)    it = $it")
}

// 发送和接收事件


sendTag("refresh_tag")

receiveEvent("refresh_tag") {
  Log.d("日志", "(MainActivity.kt:25)    tag = $it") // refresh_tag
  
}

// 发送和接收标签事件
```



## 发送



发送事件+标签

```kotlin
fun sendEvent(
  event: Any,  // 事件
  tag: String = "",  // 标签
)
```



仅发送标签

```kotlin
fun sendTag(tag: String)
```



## 接收事件

```kotlin
inline fun <reified T> LifecycleOwner.receive(
    active: Boolean = false,
    vararg tags: String = arrayOf(),
    lifecycleEvent: Lifecycle.Event = Lifecycle.Event.ON_DESTROY,
    noinline block: suspend CoroutineScope.(event: T) -> Unit
): ChannelScope

fun LifecycleOwner.receiveTag(
    active: Boolean = false,
    vararg tags: String,
    lifecycleEvent: Lifecycle.Event = Lifecycle.Event.ON_DESTROY,
    block: suspend CoroutineScope.(tag: String) -> Unit
): ChannelScope
```



1. 发送事件加标签时使用`receive`接收其事件, 如果发送时有指定标签,则接收时应该也指定其标签才能接收到其事件
2. 仅发送标签时使用`receiveTag`可以接收到该事件, 可以同时接收多个标签的事件
3. `active`表示只有当Activity或Fragment处于活跃状态时才会收到事件, 如果未活跃时发送则等待到活跃时收到
4. 只有`LifecycleOwner`扩展函数才会在销毁时自动注销作用域



活跃状态: 非`onPause`或者`onDestroy`都属于正在活跃中



需要手动注销的接收者

```
fun receiveTag(
    vararg tags: String,
    block: suspend CoroutineScope.(tag: String) -> Unit
): ChannelScope

inline fun <reified T> receiveEvent(
    vararg tags: String = arrayOf(),
    noinline block: suspend (event: T) -> Unit
): ChannelScope
```



## 异常捕捉

```kotlin
receiveEvent("refresh_tag") {
  Log.d("日志", "(MainActivity.kt:25)    tag = $it") // refresh_tag
  
}.catch { // 当作用域中发生异常
  
	// it 为异常对象
}.finaly {
	// 无论正常或者异常结束后回调, it表示异常对象, 如果为null表示正常结束
}
```

