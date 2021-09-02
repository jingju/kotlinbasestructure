package com.doit.kotlinbasesture.login

import com.doit.kotlinbasesture.bean.LoginBean
import com.doit.kotlinbasesture.bean.RegistBean
import com.doit.networklibrary.BaseResponse
import okhttp3.RequestBody
import retrofit2.http.Body
import retrofit2.http.Field
import retrofit2.http.FormUrlEncoded
import retrofit2.http.POST

interface LoginApi {
    /**
     * 注册
     */
    @FormUrlEncoded
    @POST("user/register")
    suspend fun register(@Field("username") username: String,@Field("password") password: String
                         ,@Field("repassword") repassword: String) : BaseResponse<RegistBean>

    /**
     * 登录
     */
    @POST("/user/v1/user/login")
    suspend fun login(@Body body: RequestBody): BaseResponse<UserInfoBean>



}
