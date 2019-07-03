# SimpleComponent
组件化架构
====
架构图
----
![架构图](https://github.com/zhongxiong00/SimpleComponent/blob/master/pics/%E6%9E%B6%E6%9E%84%E5%9B%BE.jpg) 
说明
----
1.配置某个组件作为app独立运行时，需要在根目录下的gradle.properties修改变量，如下：
```Java
#指定各个module是否单独运行
isModuleH5Alone=true
isModuleMainAlone=false
isModulelHomeAlone=false
```
2.build.gradle文件的配置参考其他module.

3.当某个组件作为app独立运行时，需要用单独测试的Application,在module下建立debug目录并创建Application继承BaseApplicaion即可。
否则创建一个AppDelegate实现IApplicationDelegate接口并且在LibCommon下的AppConfig中注册.

4.各个组件之间的交互需要在LibCommon下定义接口或者使用Aroute来通信




