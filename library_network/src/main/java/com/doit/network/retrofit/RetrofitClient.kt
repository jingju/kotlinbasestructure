package com.doit.network.retrofit

import com.doit.network.api.ApiService
import com.doit.network.base.BaseRetrofitClient
import okhttp3.OkHttpClient

/**
 * RetrofitClient
 */
object RetrofitClient : BaseRetrofitClient() {

    //url
    private const val BASE_URL = "http://test-ns.htexam.com/"

    val service by lazy { getService(ApiService::class.java, BASE_URL) }

    override fun handleBuilder(builder: OkHttpClient.Builder) = Unit
}