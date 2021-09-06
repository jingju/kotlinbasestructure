package com.doit.networklibrary

import android.service.autofill.Dataset

class  BaseResponse<T>{
    var code:Int=0
    var message:String?=null
    var data:T?=null
    //todo
    /**
     *  success 还是 error
     *
     *  如果是error,走错误的回调处理
     *
     *  .//todo empty的不走了。
     *
     */
    var state:DataState?=null
}
enum class DataState {
    //todo 暂时只有两个状态
    STATE_SUCCESS,//成功
    STATE_FAILED,//请求失败
}

//enum class DataState {
//    STATE_CREATE,//创建
//    STATE_LOADING,//加载中
//    STATE_SUCCESS,//成功
//    STATE_COMPLETED,//完成
//    STATE_EMPTY,//数据为null
//    STATE_FAILED,//接口请求成功但是服务器返回error
//    STATE_ERROR,//请求失败
//    STATE_UNKNOWN//未知
//}