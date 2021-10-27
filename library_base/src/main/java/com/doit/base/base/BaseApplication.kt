package com.doit.base.base

import android.app.Activity
import android.app.Application
import android.os.Bundle
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

    override fun onCreate() {
        super.onCreate()
        init()
        setApplication(this)
    }

    private fun init() {
        LoadSir.beginBuilder()
            .addCallback(ErrorCallback())
            .addCallback(EmptyCallback())
            .addCallback(LoadingCallback())
            .commit()
    }

    private fun setApplication(application: BaseApplication) {
        application.registerActivityLifecycleCallbacks(object : ActivityLifecycleCallbacks {
            override fun onActivityCreated(activity: Activity, savedInstanceState: Bundle?) {
                AppManager.addActivity(activity)
            }

            override fun onActivityStarted(activity: Activity) {
            }

            override fun onActivityResumed(activity: Activity) {
            }

            override fun onActivityPaused(activity: Activity) {
            }

            override fun onActivityStopped(activity: Activity) {
            }

            override fun onActivitySaveInstanceState(activity: Activity, outState: Bundle) {
            }

            override fun onActivityDestroyed(activity: Activity) {
                AppManager.removeActivity(activity)
            }
        })
    }
}