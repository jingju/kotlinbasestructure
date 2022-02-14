package com.doit.base.view

import android.content.Context
import android.util.AttributeSet
import android.view.MotionEvent
import androidx.viewpager.widget.ViewPager

class CustomViewPager : ViewPager {

    constructor(context: Context) : super(context)

    constructor(context: Context, attrs: AttributeSet?) : super(context, attrs)

    private var canScroll: Boolean = true
    private var smoothScroll: Boolean = true

    /**
     * 设置其是否能滑动换页
     *
     * @param canScroll false 不能换页， true 可以滑动换页
     */
    fun setCanScroll(canScroll: Boolean) {
        this.canScroll = canScroll
    }

    /**
     * 设置其是否需要滑动动画
     *
     * @param smoothScroll false 不要动画， true 要动画
     */
    fun setSmoothScroll(smoothScroll: Boolean) {
        this.smoothScroll = smoothScroll
    }

    override fun onInterceptTouchEvent(ev: MotionEvent?): Boolean {
        return canScroll && super.onInterceptTouchEvent(ev)
    }

    override fun onTouchEvent(ev: MotionEvent?): Boolean {
        return canScroll && super.onTouchEvent(ev)
    }

    override fun setCurrentItem(item: Int) {
        super.setCurrentItem(item, this.smoothScroll)
    }
}