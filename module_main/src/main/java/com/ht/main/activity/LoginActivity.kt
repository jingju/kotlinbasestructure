package com.ht.main.activity

import android.os.Bundle
import androidx.activity.viewModels
import com.alibaba.android.arouter.facade.annotation.Route
import com.doit.base.activity.BaseActivity
import com.doit.base.utils.ToastUtil
import com.doit.base.utils.launchWithLoading
import com.doit.base.utils.launchWithLoadingAndCollect
import com.doit.network.bean.UserInfoBean
import com.doit.network.observer.observeState
import com.doit.network.utils.toast
import com.ht.main.R
import com.ht.main.databinding.ActivityLoginBinding
import com.ht.main.viewModel.LoginViewModel

@Route(path = "/main/LoginActivity")
class LoginActivity : BaseActivity<ActivityLoginBinding>() {

    private val mViewModel by viewModels<LoginViewModel>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        mViewModel.attachUi(viewDataBinding!!)
    }

    override fun onDestroy() {
        super.onDestroy()
        mViewModel.detachUi()
    }

    override fun init() {
        initData()
        initObserver()
    }

    override fun getLayoutId(): Int {
        return R.layout.activity_login;
    }

    override fun onRetryBtnClick() {
    }

    private fun initData() {
        setLoadSir(viewDataBinding!!.refreshLayout)
        viewDataBinding!!.btnDo.setOnClickListener {
            launchWithLoading<ActivityLoginBinding> {
                mViewModel.login("1234567890123", "12345678")
            }
        }
    }

    private fun initObserver() {
        mViewModel.mUserLiveData.observeState(this) {
            onSuccess = { data: UserInfoBean? ->
                ToastUtil.show(this@LoginActivity, "onSuccess")
            }

            onDataEmpty = {
                ToastUtil.show(this@LoginActivity, "onDataEmpty")
            }

            onComplete = this@LoginActivity::dismissLoading

            onFailed = { code, msg ->
                ToastUtil.show(this@LoginActivity, "errorCode: $code   errorMsg: $msg")
            }

            onError = {
                ToastUtil.show(this@LoginActivity, it.message)
            }
        }
    }
}