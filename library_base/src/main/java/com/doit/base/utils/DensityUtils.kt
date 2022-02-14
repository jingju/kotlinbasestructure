package com.doit.base.utils

import android.content.Context
import android.os.Build
import android.util.DisplayMetrics
import android.util.TypedValue
import android.view.WindowManager
import java.lang.Exception

class DensityUtils private constructor() {

    companion object {
        val instance: DensityUtils by lazy { DensityUtils() }
    }

    /**
     * dp转px
     *
     * @param context
     * @param dpVal
     * @return
     */
    fun dp2px(context: Context, dpVal: Float): Int {
        return TypedValue.applyDimension(
            TypedValue.COMPLEX_UNIT_DIP,
            dpVal, context.resources.displayMetrics
        ).toInt()
    }

    fun dp2floatpx(context: Context, dpVal: Float): Float {
        return TypedValue.applyDimension(
            TypedValue.COMPLEX_UNIT_DIP,
            dpVal, context.resources.displayMetrics
        )
    }

    /**
     * sp转px
     *
     * @param context
     * @param spVal
     * @return
     */
    fun sp2px(context: Context, spVal: Float): Int {
        return TypedValue.applyDimension(
            TypedValue.COMPLEX_UNIT_SP,
            spVal, context.resources.displayMetrics
        ).toInt()
    }

    /**
     * px转dp
     *
     * @param context
     * @param pxVal
     * @return
     */
    fun px2dp(context: Context, pxVal: Float): Float {
        val scale = context.resources.displayMetrics.density
        return pxVal / scale
    }

    /**
     * px转sp
     *
     * @param context
     * @param pxVal
     * @return
     */
    fun px2sp(context: Context, pxVal: Float): Float {
        return pxVal / context.resources.displayMetrics.scaledDensity
    }

    fun getScreenSize(context: Context): String? {
        val metrics = DisplayMetrics()
        (context.getSystemService(Context.WINDOW_SERVICE) as WindowManager).defaultDisplay.getMetrics(
            metrics
        )
        val screenWidth = metrics.widthPixels //.widthPixels;
        val screenHeigh = metrics.heightPixels //.heightPixels;
        return screenWidth.toString() + "_" + screenHeigh
    }

    fun getScreenWidth(context: Context): Int {
        val metrics = DisplayMetrics()
        (context.getSystemService(Context.WINDOW_SERVICE) as WindowManager).defaultDisplay.getMetrics(
            metrics
        )
        return metrics.widthPixels //.widthPixels;
    }

    fun getScreenHeight(context: Context): Int {
        val metrics = DisplayMetrics()
        (context.getSystemService(Context.WINDOW_SERVICE) as WindowManager).defaultDisplay.getMetrics(
            metrics
        )
        return metrics.heightPixels //.widthPixels;
    }

    //获取屏幕原始尺寸高度，包括虚拟功能键高度
    fun getHasVirtualKey(context: Context): Int {
        var dpi = 0
        val windowManager = context.getSystemService(Context.WINDOW_SERVICE) as WindowManager
        val display = windowManager.defaultDisplay
        val displayMetrics = DisplayMetrics()
        val c: Class<*>
        try {
            c = Class.forName("android.view.Display")
            val method = c.getMethod("getRealMetrics", DisplayMetrics::class.java)
            method.invoke(display, displayMetrics)
            dpi = displayMetrics.heightPixels
        } catch (e: Exception) {
            e.printStackTrace()
        }
        return dpi
    }

    /**
     * 获得状态栏的高度
     */
    fun getStatusHeight(context: Context): Int {
        var statusHeight = -1
        try {
            val clazz = Class.forName("com.android.internal.R\$dimen")
            val `object` = clazz.newInstance()
            val height = clazz.getField("status_bar_height")[`object`].toString().toInt()
            statusHeight = context.resources.getDimensionPixelSize(height)
        } catch (e: Exception) {
            e.printStackTrace()
        }
        return statusHeight
    }

    fun getStatusHeightV2(context: Context): Int {
        return if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT) getStatusHeight(context) else 0
    }

    /**
     * 获取 DisplayMetrics
     *
     * @return
     */
    fun getDisplayMetrics(context: Context): DisplayMetrics? {
        val displayMetrics = DisplayMetrics()
        (context.applicationContext.getSystemService(Context.WINDOW_SERVICE) as WindowManager)
            .defaultDisplay.getMetrics(displayMetrics)
        return displayMetrics
    }
}