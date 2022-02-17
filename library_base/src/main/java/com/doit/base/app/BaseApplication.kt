package com.doit.base.app

import android.app.Application
import com.doit.base.loadsir.EmptyCallback
import com.doit.base.loadsir.ErrorCallback
import com.doit.base.loadsir.LoadingCallback
import com.kingja.loadsir.core.LoadSir

/**
 *
 * @Description:
 * @CreateDate: 2021/10/6 1:02 下午
 * @Author: yzp
 */
abstract class BaseApplication : Application() {

    companion object {
        private lateinit var instance: Application
        fun instance() = instance
    }

    override fun onCreate() {
        super.onCreate()
        registerActivityLifecycleCallbacks(ActivityLifecycleCallbacksImpl())
        instance = this
        init()
    }

    private fun init() {
        LoadSir.beginBuilder()
            .addCallback(ErrorCallback())
            .addCallback(EmptyCallback())
            .addCallback(LoadingCallback())
            .commit()
    }
}