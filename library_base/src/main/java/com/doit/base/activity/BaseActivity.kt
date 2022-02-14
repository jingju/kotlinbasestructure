package com.doit.base.activity

import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding
import com.doit.base.loadsir.EmptyCallback
import com.doit.base.loadsir.ErrorCallback
import com.doit.base.loadsir.LoadingCallback
import com.doit.base.utils.ToastUtils
import com.doit.base.view.IBaseView
import com.kingja.loadsir.core.LoadService
import com.kingja.loadsir.core.LoadSir

/**
 *
 * 应用模块: activity
 * <p>
 * 类描述: activity抽象基类
 */
abstract class BaseActivity<V : ViewDataBinding> : AppCompatActivity(), IBaseView {

    var viewDataBinding: V? = null
    private var mLoadService: LoadService<*>? = null
    private var isShowedContent = false

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        performDataBinding()
        init()
    }

    override fun onDestroy() {
        super.onDestroy()
    }

    abstract fun init()

    private fun performDataBinding() {
        viewDataBinding = DataBindingUtil.setContentView(this, getLayoutId())
    }

    /**
     * 注册LoadSir
     * @param view 替换视图
     */
    open fun setLoadSir(view: View) {
        if (mLoadService == null) {
            mLoadService = LoadSir.getDefault()
                .register(view) { onRetryBtnClick() }
        }
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
                ToastUtils.show(this, message)
            }
        }
    }
}