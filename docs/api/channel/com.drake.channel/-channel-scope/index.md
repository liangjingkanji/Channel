[channel](../../index.md) / [com.drake.channel](../index.md) / [ChannelScope](./index.md)

# ChannelScope

`open class ChannelScope : CoroutineScope`

异步协程作用域

### Constructors

| Name | Summary |
|---|---|
| [&lt;init&gt;](-init-.md) | `ChannelScope(lifecycleOwner: LifecycleOwner, lifeEvent: Event = Lifecycle.Event.ON_DESTROY)`<br>异步协程作用域`ChannelScope()` |

### Properties

| Name | Summary |
|---|---|
| [auto](auto.md) | `var auto: `[`Boolean`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-boolean/index.html) |
| [catch](catch.md) | `var catch: (`[`ChannelScope`](./index.md)`.(`[`Throwable`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-throwable/index.html)`) -> `[`Unit`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html)`)?` |
| [coroutineContext](coroutine-context.md) | `open val coroutineContext: `[`CoroutineContext`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.coroutines/-coroutine-context/index.html) |
| [finally](finally.md) | `var finally: (`[`ChannelScope`](./index.md)`.(`[`Throwable`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-throwable/index.html)`?) -> `[`Unit`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html)`)?` |

### Functions

| Name | Summary |
|---|---|
| [autoOff](auto-off.md) | `fun autoOff(): `[`Unit`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html) |
| [catch](catch.md) | `open fun catch(e: `[`Throwable`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-throwable/index.html)`): `[`Unit`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html)<br>当作用域内发生异常时回调`open fun catch(block: `[`ChannelScope`](./index.md)`.(`[`Throwable`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-throwable/index.html)`) -> `[`Unit`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html)` = {}): `[`ChannelScope`](./index.md) |
| [finally](finally.md) | `open fun finally(e: `[`Throwable`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-throwable/index.html)`?): `[`Unit`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html)<br>无论正常或者异常结束都将最终执行`open fun finally(block: `[`ChannelScope`](./index.md)`.(`[`Throwable`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-throwable/index.html)`?) -> `[`Unit`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html)` = {}): `[`ChannelScope`](./index.md) |
| [handleError](handle-error.md) | 错误处理`open fun handleError(e: `[`Throwable`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-throwable/index.html)`): `[`Unit`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html) |
| [launch](launch.md) | `open fun launch(block: suspend CoroutineScope.() -> `[`Unit`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html)`): `[`ChannelScope`](./index.md) |
| [start](start.md) | `open fun start(): `[`Unit`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html) |
