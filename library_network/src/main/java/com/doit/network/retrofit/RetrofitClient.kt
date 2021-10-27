package com.doit.network.retrofit

import com.doit.network.api.ApiService
import com.doit.network.base.BaseRetrofitClient
import okhttp3.OkHttpClient

/**
 * RetrofitClient
 */
object RetrofitClient : BaseRetrofitClient() {

    val service by lazy { getService(ApiService::class.java, BASE_URL) }

    override fun handleBuilder(builder: OkHttpClient.Builder) = Unit
}