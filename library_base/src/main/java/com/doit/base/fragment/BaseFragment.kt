package com.doit.base.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.annotation.LayoutRes
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding
import androidx.fragment.app.Fragment
import com.doit.base.view.IBaseView
import com.doit.base.loadsir.EmptyCallback
import com.doit.base.loadsir.ErrorCallback
import com.doit.base.loadsir.LoadingCallback
import com.doit.base.utils.ToastUtil
import com.kingja.loadsir.callback.Callback.OnReloadListener
import com.kingja.loadsir.core.LoadService
import com.kingja.loadsir.core.LoadSir

abstract class BaseFragment<V : ViewDataBinding> : Fragment(), IBaseView {

    var viewDataBinding: V? = null
    private var mLoadService: LoadService<*>? = null
    private var isShowedContent = false

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        initParameters()
    }

    /**
     * 初始化参数
     */
    protected open fun initParameters() {}

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        viewDataBinding = DataBindingUtil.inflate(inflater, getLayoutId(), container, false)
        return viewDataBinding!!.root
    }

    override fun showContent() {
        if (null != mLoadService) {
            isShowedContent = true
            mLoadService!!.showSuccess()
        }
    }

    override fun showLoading() {
        if (null != mLoadService) {
            mLoadService!!.showCallback(LoadingCallback::class.java)
        }
    }

    override fun dismissLoading() {
        showContent()
    }

    override fun showEmpty() {
        if (null != mLoadService) {
            mLoadService!!.showCallback(EmptyCallback::class.java)
        }
    }

    override fun showFailure(message: String?) {
        if (null != mLoadService) {
            if (!isShowedContent) {
                mLoadService!!.showCallback(ErrorCallback::class.java)
            } else {
                context?.let { ToastUtil.show(it, message) }
            }
        }
    }

    open fun setLoadSir(view: View?) {
        mLoadService = LoadSir.getDefault()
            .register(
                view
            ) { v: View? -> onRetryBtnClick() }
    }
}