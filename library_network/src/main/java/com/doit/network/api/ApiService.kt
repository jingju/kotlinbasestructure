package com.doit.network.api

import com.doit.network.base.BaseResponse
import com.doit.network.bean.RegisterBean
import com.doit.network.bean.UserInfoBean
import okhttp3.RequestBody
import retrofit2.http.Body
import retrofit2.http.Field
import retrofit2.http.FormUrlEncoded
import retrofit2.http.POST

interface ApiService {
    /**
     * 注册
     */
    @FormUrlEncoded
    @POST("user/register")
    suspend fun register(
        @Field("username") username: String,
        @Field("password") password: String,
        @Field("repassword") repassword: String
    ): BaseResponse<RegisterBean>

    /**
     * 登录
     */
    @POST("/user/v1/user/login")
    suspend fun login(@Body body: RequestBody): BaseResponse<UserInfoBean>
}
