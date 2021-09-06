package com.doit.kotlinbasesture

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.doit.kotlinbasesture.login.LoginActivity
import kotlinx.android.synthetic.main.activity_main.*
/**
 *
 *  从try catche 封装错误，也可以容awaitResponse来封装
 *
 */
class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        toLogin.setOnClickListener {
            toLogin()
        }

    }
    fun toLogin(){
        var intent: Intent = Intent(this, LoginActivity::class.java)
        startActivity(intent)
    }
}