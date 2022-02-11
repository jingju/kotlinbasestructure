package com.doit.base.fragment

import android.os.Bundle
import androidx.databinding.ViewDataBinding

abstract class BaseLazyFragment<V : ViewDataBinding> : BaseFragment<V>() {

    /** 第一次显示出来（用户第一次看到时） */
    protected abstract fun onFirstVisibleToUser()

    /** 每次显示出来（除去第一次） */
    protected abstract fun onVisibleToUser()

    /** 每次隐藏时 */
    protected abstract fun onInvisibleToUser()

    private var isFirstVisible: Boolean = true
    private var isPrepared: Boolean = false

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        initPrepare()
    }

    override fun onResume() {
        super.onResume()
        if (isFirstVisible) {
            initPrepare();
            isFirstVisible = false;
        } else {
            onVisibleToUser();
        }
    }

    override fun onPause() {
        super.onPause()
        onInvisibleToUser()
    }

    @Synchronized
    private fun initPrepare() {
        if (isPrepared) {
            onFirstVisibleToUser()
        } else {
            isPrepared = true
        }
    }
}