package com.doit.base.view

import androidx.annotation.LayoutRes

/**
 *
 * 应用模块: activity
 * <p>
 * 类描述: 界面UI显示切换
 */
interface IBaseView {

    /**
     * 布局
     */
    @LayoutRes
    fun getLayoutId(): Int

    /**
     * 显示内容
     */
    fun showContent()

    /**
     * 显示加载提示
     */
    fun showLoading()

    /**
     * 关闭加载提示
     */
    fun dismissLoading()

    /**
     * 显示空页面
     */
    fun showEmpty()

    /**
     * 刷新失败
     */
    fun showFailure(message: String?)

    /**
     * 失败重试,重新加载事件
     */
    fun onRetryBtnClick()
}