package com.ht.main.viewModel

import com.doit.base.viewmodel.BaseViewModel
import com.doit.network.bean.UserInfoBean
import com.doit.network.observer.StateMutableLiveData
import com.ht.main.databinding.ActivityLoginBinding
import com.ht.main.repository.LoginRepository

/**
 *
 * 1、 谷歌建议，一个页面只有一个viewModel
 * 2、可以在viewModel里面创建多个repository
 * 3、在repository调用的时候将livedata传递过去
 */
class LoginViewModel : BaseViewModel<ActivityLoginBinding>() {

    private val repository by lazy { LoginRepository() }

    val mUserLiveData = StateMutableLiveData<UserInfoBean>()

    suspend fun login(phoneNum: String, password: String) {
        mUserLiveData.value = repository.login(phoneNum, password)
    }
}