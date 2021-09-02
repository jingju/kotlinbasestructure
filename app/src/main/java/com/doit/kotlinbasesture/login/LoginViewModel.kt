package com.doit.kotlinbasesture.login

import androidx.lifecycle.viewModelScope
import com.doit.baselibrary.BaseViewModel
import com.doit.networklibrary.StateLiveData
import kotlinx.coroutines.launch

/**
 * todo tip
 *
 *1、 谷歌建议，一个页面只有一个viewModel
 *
 * 2、可以在viewModel里面创建多个repository
 *
 * 3、在repository调用的时候将livedata传递过去
 *
 *
 *
 */
class LoginViewModel:BaseViewModel(){
    val mLoginRepo:LoginRepo=LoginRepo()
    val mLoginLiveData =StateLiveData<UserInfoBean>()

    fun login(){
        viewModelScope.launch {
            // TODO: 2021/8/24 livedata
            mLoginRepo.login("","",mLoginLiveData);
        }
    }
}