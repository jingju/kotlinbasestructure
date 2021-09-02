package com.doit.kotlinbasesture.net

import com.doit.kotlinbasesture.login.UserInfo
import com.doit.networklibrary.BaseResponse
import okhttp3.RequestBody
import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.POST

/**
 * 登录相关接口测试用
 */
interface LoginService {

    /**
     * 手机号密码登录
     */
    @POST("/user/v1/user/login")
    suspend fun login(@Body body: RequestBody?): Call<BaseResponse<UserInfo>>

}