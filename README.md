# 基础框架搭建

## 架构与相关技术

    架构
    1、开发语言 kotlin
    2、组件框架：Arouter
    3、架构：MVVM + JetPack
            MVVM：View  Mode  ViewMode  Repository
            JetPack: ViewBinding  DataBinding  LiveData  ViewMode  LifeCycle  navigation
    4、HTTP封装：Flow  协程  Retrofit

    相关技术
    1、底部导航：BottomNavigationView
    2、BaseAdapter、BasePagerAdapter封装
    3、状态栏适配 ----  ImmersionBar
    4、轮播图  ----  XBanner 
    5、自定义控件：
        CustomDialog、CustomPopupWindow、CustomViewPager（是否支持滑动）
    6、工具类
        ActivityHelper、DensityUtils、DateUtils、NetWorkUtils、ToastUtils
    7、文件下载封装
    8、6.0适配

    三方框架（1、选择业界著名框架  2、能自己封装就自己封装减小无用代码体积  3、知其框架原理合理选择）
    1、
    2、

## 技术对比

    1、kotlin-android-extensions VS ViewBinding
        1）kotlin-android-extensions 废弃不在支持
        2）仅支持 Kotlin 代码
        3）污染全局命名空间
        4）不能暴露可空性信息
        5）ViewBinding官方支持，编译速度更快
    2、GreenDao VS Room
        API
        1）GreenDao不支持LiveData，Room支持LiveData
        2）GreenDao集成了SqlCipher加密，Room不支持SqlCipher加密
        3）熟悉SQL语句，Room会更容易上手
        4）GreenDao只有进行复杂操作时才需要写SQL语句，Room即使是进行简单的条件查询，也要写SQL语句

        速度对比
        插入数据 - 插入1000条user数据和10000条message数据
        查询全部 - 查询所有 (10000条)message数据
                SQLite	    GreenDao	    Room
        插入数据	5653	    2771	        1441
        查询全部	611	        750	            411

## 问题总结

    1、
    2、

