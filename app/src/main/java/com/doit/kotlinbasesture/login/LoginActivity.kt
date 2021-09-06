package com.doit.kotlinbasesture.login

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import com.doit.kotlinbasesture.R
import com.doit.networklibrary.MultiStateObserver
import kotlinx.android.synthetic.main.activity_login.*

class LoginActivity : AppCompatActivity(){

    private val mLoginViewModel:LoginViewModel=LoginViewModel()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)
        onInitView()
        doLogin.setOnClickListener { view ->
            doLogin()
        }

    }

    fun onInitView() {

        mLoginViewModel.mLoginLiveData.observe(this, object:MultiStateObserver<UserInfoBean>(){
            /**
             * 请求成功的回调用
             */
            override fun onDataChange(data: UserInfoBean?) {
                super.onDataChange(data)
                //
                Log.d("kotlin","name="+ data!!.nickName)
            }

            override fun onFailed() {
                super.onFailed()
            }


        })
    }


   fun doLogin(){
       mLoginViewModel.login()
   }
}