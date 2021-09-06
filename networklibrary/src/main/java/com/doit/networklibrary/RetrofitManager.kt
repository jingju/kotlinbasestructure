package com.doit.networklibrary

import android.util.Log
import okhttp3.Interceptor
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit

private const val TAG = "RetrofitManager"

object RetrofitManager {
   private val  url:String="";//todo 加上自己的uri就可以了

    private val mOkClient = OkHttpClient.Builder()
        .callTimeout(10, TimeUnit.SECONDS)
        .connectTimeout(10, TimeUnit.SECONDS)
        .readTimeout(10, TimeUnit.SECONDS)
        .writeTimeout(10, TimeUnit.SECONDS)
        .addInterceptor(Interceptor {
            val original = it.request()
            val builder= original.newBuilder()
                .addHeader("token", "")
                .addHeader("cv", "")
                .addHeader("terminal", "1")
                .addHeader("pm", "")

            it.proceed(builder.build())

        })
        .retryOnConnectionFailure(true)
        .followRedirects(false)
        .addInterceptor(HttpLoggingInterceptor(object : HttpLoggingInterceptor.Logger {
            override fun log(message: String) {
                Log.d(TAG, "log: $message")
            }

        }).setLevel(HttpLoggingInterceptor.Level.BODY)).build()

    private var mRetrofit: Retrofit? = null
    init {
        initRetrofit()
    }

    fun initRetrofit(): RetrofitManager {
        mRetrofit = Retrofit.Builder()
            .baseUrl(url)
            .client(mOkClient)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
        return this
    }

   fun <T> getService(serviceClass: Class<T>): T {
        if (mRetrofit == null) {
            throw UninitializedPropertyAccessException("Retrofit必须初始化")
        } else {
            return mRetrofit!!.create(serviceClass)
        }
    }

}

/**
 * todo 通过扩展函数封装到这里
 * todo zans
 *  1、根据不同app的errorCode做特殊处理的接口
 *  2、写一个结果转换器，做成不同状态的回调的显示，可以用扩展函数和map
 *
 */
suspend fun <T> RetrofitManager.request(block:suspend ()->BaseResponse<T>,
                                        stateLiveData:StateLiveData<T>){
    var baseResp = BaseResponse<T>()
    try {
         //todo 这个状态先不做判断

//        baseResp.dataState = DataState.STATE_LOADING

        //开始请求数据
        val invoke = block.invoke()
        //将结果复制给baseResp
        baseResp = invoke

        //todo  code 只做一些特殊的处理，其它都是正常的

        if (baseResp.code == 1000000) {
            //请求成功，判断数据是否为空，
            //因为数据有多种类型，需要自己设置类型进行判断

//            if (baseResp.data == null || baseResp.data is List<*> && (baseResp.data as List<*>).size == 0) {
//                //TODO: 数据为空,结构变化时需要修改判空条件
//                baseResp.dataState = DataState.STATE_EMPTY
//            } else {
//                //请求成功并且数据为空的情况下，为STATE_SUCCESS
//                baseResp.dataState = DataState.STATE_SUCCESS
//            }
            baseResp.state=DataState.STATE_SUCCESS

        } else {
            //todo 服务器请求错误，也封装成error，在也面活这统一处理
            baseResp.state = DataState.STATE_FAILED
        }
    } catch (e: Exception) {
        //todo 非后台返回错误，捕获到的异常
            //todo [text={"data":null,"message":"非法的参数","code":1000101}]后台的非法参数也按错误返回了
        baseResp.state = DataState.STATE_FAILED
//        baseResp.error = e
    } finally {
        stateLiveData.postValue(baseResp)
    }

}
