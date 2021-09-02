package com.doit.networklibrary

class  BaseResponse<T>{
    var code:Int=0;
    var message:String?=null;
    var data:T?=null;
    //todo
    /**
     *  success 还是 error
     *
     *  如果是error,走错误的回调处理
     *
     *  .//todo empty的不走了。
     *
     */
    var state:Int?=0//  success 还是 error,如果是err
}