## Channel

<p align="center"><img src="https://i.imgur.com/FlRSoGc.jpg" width="300"/></p>

<p align="center"><strong>基于最新特性的Android事件分发框架</strong></p>

<p align="center"><a href="http://liangjingkanji.github.io/Channel/">使用文档</a> | <a href="https://coding-pages-bucket-3558162-8706000-16643-587720-1252757332.cos-website.ap-shanghai.myqcloud.com/">备用访问</a></p>

<p align="center"><img src="https://i.imgur.com/TsYMHWc.png" width="400"/></p>

<p align="center">
<a href="https://jitpack.io/#liangjingkanji/Channel"><img src="https://jitpack.io/v/liangjingkanji/Channel.svg"/></a>
<img src="https://img.shields.io/badge/language-kotlin-orange.svg"/>
<img src="https://img.shields.io/badge/license-Apache-blue"/>
<a href="https://liangjingkanji.github.io/Channel/api/"><img src="https://img.shields.io/badge/api-%E5%87%BD%E6%95%B0%E6%96%87%E6%A1%A3-red"/></a>
<a href="https://jq.qq.com/?_wv=1027&k=vWsXSNBJ"><img src="https://img.shields.io/badge/QQ群-752854893-blue"/></a>
</p>


### 特点

- [x] 基于`kotlin`的优雅函数设计
- [x] 基于`协程`实现异步处理和异常捕捉
- [x] 基于`liveData`实现前台数据接收
- [x] 基于`lifeCycle`实现生命周期绑定
- [x] 无注解不增加编译耗时
- [x] 体积小巧仅6kb
- [x] 完善的文档和帮助
- [x] 上手简单, 仅四个主要函数

### 功能

- [x] 发送消息 + 标签事件
- [x] 仅发送标签
- [x] 自动注销(支持手动取消观察者)
- [x] 接收消息属于异步主线程作用域
- [x] 消息延迟到应用前台时接收(liveData)


<br>

## 安装

添加远程仓库根据创建项目的 Android Studio 版本有所不同

Android Studio Arctic Fox以下创建的项目 在项目根目录的 build.gradle 添加仓库

```groovy
allprojects {
    repositories {
        // ...
        maven { url 'https://jitpack.io' }
    }
}
```

Android Studio Arctic Fox以上创建的项目 在项目根目录的 settings.gradle 添加仓库

```kotlin
dependencyResolutionManagement {
    repositories {
        // ...
        maven { url 'https://jitpack.io' }
    }
}
```

然后在 module 的 build.gradle 添加依赖框架

```groovy
implementation "org.jetbrains.kotlinx:kotlinx-coroutines-android:1.5.1"

implementation 'com.github.liangjingkanji:Channel:1.1.5'
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
