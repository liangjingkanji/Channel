## Channel

<p align="center"><img src="https://i.imgur.com/FlRSoGc.jpg" width="300"/></p>

<p align="center"><strong>基于最新特性的Android事件分发框架</strong></p>

<p align="center"><a href="http://liangjingkanji.github.io/Channel/">使用文档</a></p>

<p align="center"><img src="https://i.imgur.com/OitdJ2V.jpg" width="300"/></p>

<p align="center">
<a href="https://jitpack.io/#liangjingkanji/Channel"><img src="https://jitpack.io/v/liangjingkanji/Channel.svg"/></a>
<img src="https://img.shields.io/badge/language-kotlin-orange.svg"/>
<img src="https://img.shields.io/badge/license-Apache-blue"/>
<a href="https://jq.qq.com/?_wv=1027&k=vWsXSNBJ"><img src="https://img.shields.io/badge/QQ群-752854893-blue"/></a>
</p>


### 特点

-   基于`Kotlin`的简洁API设计
-   扩展`协程`实现异步处理和异常捕捉
-   扩展`LiveData`实现前台数据接收
-   扩展`LifeCycle`实现生命周期绑定
-   无注解不影响编译时间
-   体积小巧仅6kb
-   完善的文档和帮助
-   上手简单, 仅四个主要函数

### 功能

- [x] 发送消息 + 标签
- [x] 仅发送标签
- [x] 自动注销
- [x] 自定义注销的生命周期, 手动取消观察者
- [x] 接收消息属于异步主线程作用域
- [x] 捕捉异常
- [x] 回调 catch/finaly
- [x] 消息延迟到应用前台时接收



>   任何问题可点击QQ群图标, 联系作者技术帮助



<br>

在项目根目录的 build.gradle 添加仓库

```groovy
allprojects {
    repositories {
        // ...
        maven { url 'https://jitpack.io' }
    }
}
```

在 module 的 build.gradle 添加依赖

```groovy
implementation "org.jetbrains.kotlinx:kotlinx-coroutines-core:1.3.9"
implementation "org.jetbrains.kotlinx:kotlinx-coroutines-android:1.3.9"

implementation 'com.github.liangjingkanji:Channel:1.1.0'
```

<br>

## License

```
Licensed under the Apache License, Version 2.0 (the "License");
you may not use this file except in compliance with the License.
You may obtain a copy of the License at

http://www.apache.org/licenses/LICENSE-2.0

Unless required by applicable law or agreed to in writing, software
distributed under the License is distributed on an "AS IS" BASIS,
WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
See the License for the specific language governing permissions and
limitations under the License.
```
