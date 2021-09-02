package com.doit.kotlinbasesture.login

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.doit.networklibrary.MultiStateObserver

class LoginActivity : AppCompatActivity() {

    private val mLoginViewModel:LoginViewModel=LoginViewModel()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    fun OnInitView() {

        mLoginViewModel.mLoginLiveData.observe(this, object:MultiStateObserver<UserInfoBean>(){
            /**
             * 请求成功的回调用
             */
            override fun onDataChange(data: UserInfoBean?) {
                super.onDataChange(data)
            }


        })
    }


   fun doLogin(){
       mLoginViewModel.login()
   }
}