package com.doit.base.app

import android.app.Activity
import java.util.*

object ActivityHelper {

    // 管理栈
    private val activityStack by lazy { Stack<Activity>() }

    /**
     * 添加Activity到堆栈
     */
    fun addActivity(activity: Activity?) {
        activityStack.add(activity)
    }

    /**
     * 移除指定的Activity
     */
    fun removeActivity(activity: Activity) {
        if (activityStack.contains(activity)) {
            activity.finish()
            activityStack.remove(activity)
        }
    }

    /**
     * 是否有activity
     */
    fun isActivity(): Boolean {
        return activityStack.isEmpty()
    }

    /**
     * 获取当前Activity（堆栈中最后一个压入的）
     */
    fun currentActivity(): Activity {
        return activityStack.lastElement()
    }

    /**
     * 结束当前Activity（堆栈中最后一个压入的）
     */
    fun finishActivity() {
        val activity: Activity = activityStack.lastElement()
        finishActivity(activity)
    }

    /**
     * 结束指定的Activity
     */
    private fun finishActivity(activity: Activity?) {
        if (activity != null) {
            if (!activity.isFinishing) {
                activity.finish()
            }
        }
    }

    /**
     * 结束指定类名的Activity
     */
    fun finishActivity(cls: Class<*>) {
        for (activity in activityStack) {
            if (activity.javaClass == cls) {
                finishActivity(activity)
                break
            }
        }
    }

    /**
     * 结束所有Activity
     */
    private fun finishAllActivity() {
        var i = 0
        val size: Int = activityStack.size
        while (i < size) {
            if (null != activityStack[i]) {
                finishActivity(activityStack[i])
            }
            i++
        }
        activityStack.clear()
    }

    /**
     * 获取指定的Activity
     *
     * @author kymjs
     */
    fun getActivity(cls: Class<*>): Activity? {
        for (activity in activityStack) {
            if (activity.javaClass == cls) {
                return activity
            }
        }
        return null
    }

    /**
     * 退出应用程序
     */
    fun exitApp() {
        try {
            finishAllActivity()
        } catch (e: Exception) {
            activityStack.clear()
            e.printStackTrace()
        }
    }
}