package com.doit.kotlin.activtiy

import android.os.Bundle
import com.doit.base.activity.BaseActivity
import com.doit.kotlin.R
import com.doit.kotlin.databinding.AppActivityMainBinding

class AppActivity : BaseActivity<AppActivityMainBinding>() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun init() {
    }

    override fun onRetryBtnClick() {
    }

    override fun getLayoutId(): Int {
        return R.layout.app_activity_main;
    }
}