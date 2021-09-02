package com.doit.kotlinbasesture.login

import com.doit.baselibrary.BaseRepository
import com.doit.networklibrary.RetrofitManager
import com.doit.networklibrary.StateLiveData
import com.doit.networklibrary.request
import okhttp3.MediaType.Companion.toMediaType
import okhttp3.RequestBody.Companion.toRequestBody

class LoginRepo : BaseRepository(){

    /**
     * 传参数，加对应的live
     */

    suspend fun login(userName:String,password:String,liveData:StateLiveData<UserInfoBean>){
        //todo 关注下，这种class的写法。
        var body:String=""
        var mediaType:String="application/json; charset=utf-8"
        var requestBody =body.toRequestBody(mediaType.toMediaType())


        RetrofitManager.request({RetrofitManager.getService(LoginApi::class.java).login(requestBody)}
        ,liveData)
    }

}