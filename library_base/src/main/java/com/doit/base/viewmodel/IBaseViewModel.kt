package com.doit.base.viewmodel

/**
 * 应用模块: viewModel
 * <p>
 * 类描述: 定义viewModel与 V 的关联
 */
interface IBaseViewModel<V> {
    /**
     * 关联View
     */
    fun attachUi(view: V)

    /**
     * 解除关联
     */
    fun detachUi()
}