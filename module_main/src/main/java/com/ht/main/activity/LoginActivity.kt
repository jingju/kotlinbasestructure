package com.ht.main.activity

import android.content.Intent
import androidx.activity.viewModels
import com.alibaba.android.arouter.facade.annotation.Route
import com.doit.base.activity.BaseActivity
import com.doit.base.utils.ToastUtils
import com.doit.base.utils.launchWithLoading
import com.doit.network.observer.observeState
import com.ht.main.R
import com.ht.main.databinding.MainActivityLoginBinding
import com.ht.main.viewModel.LoginViewModel

@Route(path = "/main/LoginActivity")
class LoginActivity : BaseActivity<MainActivityLoginBinding>() {

    private val mViewModel by viewModels<LoginViewModel>()

    override fun init() {
        initView()
        initObserver()
    }

    override fun getLayoutId(): Int {
        return R.layout.main_activity_login;
    }

    override fun onRetryBtnClick() {
    }

    private fun initView() {
        setLoadSir(viewDataBinding.refreshLayout)
        viewDataBinding.btnDo.setOnClickListener {
            launchWithLoading<MainActivityLoginBinding> {
                mViewModel.login("1234567890123", "12345678")
            }
        }
        viewDataBinding.btnNext.setOnClickListener {
            startActivity(Intent(this@LoginActivity, MainActivity::class.java))
        }
    }

    private fun initObserver() {
        mViewModel.mUserLiveData.observeState(this) {
            onSuccess = {
                ToastUtils.show(this@LoginActivity, "onSuccess")
            }

            onDataEmpty = {
                ToastUtils.show(this@LoginActivity, "onDataEmpty")
            }

            onComplete = this@LoginActivity::dismissLoading

            onFailed = { code, msg ->
                ToastUtils.show(this@LoginActivity, "errorCode: $code   errorMsg: $msg")
            }

            onError = {
                ToastUtils.show(this@LoginActivity, it.message)
            }
        }
    }
}