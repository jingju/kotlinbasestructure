package com.doit.kotlinbasesture

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.doit.kotlinbasesture.net.LoginService
import com.doit.networklibrary.RetrofitManager
import okhttp3.internal.wait
import retrofit2.await
import retrofit2.awaitResponse

/**
 *
 *  从try catche 封装错误，也可以容awaitResponse来封装
 *
 */
class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val service = RetrofitManager.getService(LoginService::class.java)

        // TODO: 8/13/21 通过await方法来做封装
        service.login().awaitResponse().let {
            //todo 这里封装response

        }
    }