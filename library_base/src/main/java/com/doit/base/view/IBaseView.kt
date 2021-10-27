package com.doit.base.view

/**
 *
 * 应用模块: activity
 * <p>
 * 类描述: 界面UI显示切换
 */
interface IBaseView {

    /**
     * 显示内容
     */
    fun showContent()

    /**
     * 显示加载提示
     */
    fun showLoading()

    /**
     * 显示空页面
     */
    fun showEmpty()

    /**
     * 刷新失败
     */
    fun showFailure(message: String?)
}