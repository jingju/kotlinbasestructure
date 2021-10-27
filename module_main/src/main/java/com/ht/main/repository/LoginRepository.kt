package com.ht.main.repository

import com.doit.network.base.BaseRepository
import com.doit.network.base.BaseResponse
import com.doit.network.bean.UserInfoBean
import com.doit.network.retrofit.RetrofitClient
import okhttp3.MediaType.Companion.toMediaType
import okhttp3.RequestBody.Companion.toRequestBody

class LoginRepository : BaseRepository() {

    private val mService by lazy {
        RetrofitClient.service
    }

    suspend fun login(phoneNum: String, password: String): BaseResponse<UserInfoBean> {
        return executeHttp {
            var body: String = "{\"phoneNum\":$phoneNum,\"password\":$password}"
            var mediaType: String = "application/json; charset=utf-8"
            var requestBody = body.toRequestBody(mediaType.toMediaType())
            mService.login(requestBody)
        }
    }

    /**
     * todo DB
     */
}