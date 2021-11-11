package com.ht.main.activity

import androidx.activity.viewModels
import com.alibaba.android.arouter.facade.annotation.Route
import com.doit.base.activity.BaseActivity
import com.doit.base.utils.ToastUtil
import com.doit.base.utils.launchWithLoading
import com.doit.network.bean.UserInfoBean
import com.doit.network.observer.observeState
import com.ht.main.R
import com.ht.main.databinding.ActivityLoginBinding
import com.ht.main.viewModel.LoginViewModel

@Route(path = "/main/LoginActivity")
class LoginActivity : BaseActivity<ActivityLoginBinding>() {

    private val mViewModel by viewModels<LoginViewModel>()

    override fun init() {
        initView()
        initObserver()
    }

    override fun getLayoutId(): Int {
        return R.layout.activity_login;
    }

    override fun onRetryBtnClick() {
    }

    private fun initView() {
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