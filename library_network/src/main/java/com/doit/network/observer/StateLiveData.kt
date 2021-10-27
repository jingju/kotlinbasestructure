package com.doit.network.observer

import androidx.annotation.MainThread
import androidx.lifecycle.LifecycleOwner
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.doit.network.base.*
import com.doit.network.utils.toast

/**
 *
 * LiveData 封装
 * LiveData：在实体类里可以通知指定某个字段的数据更新.
 * MutableLiveData：则是完全是整个实体类或者数据类型变化后才通知.不会细节到某个字段
 */
typealias StateLiveData<T> = LiveData<BaseResponse<T>>
typealias StateMutableLiveData<T> = MutableLiveData<BaseResponse<T>>

/**
 * StateMutableLiveData 封装，用来更新数据
 * @MainThread :主线程调用
 */
@MainThread
inline fun <T> StateMutableLiveData<T>.observeState(
    owner: LifecycleOwner,
    listenerBuilder: ResultBuilder<T>.() -> Unit
) {
    //also 判空处理，对比let，also有返回值
    val listener = ResultBuilder<T>().also(listenerBuilder)
    observe(owner) { BaseResponse ->
        when (BaseResponse) {
            is BaseSuccessResponse -> listener.onSuccess(BaseResponse.response)
            is BaseEmptyResponse -> listener.onDataEmpty()
            is BaseFailedResponse -> listener.onFailed(
                BaseResponse.errorCode,
                BaseResponse.errorMsg
            )
            is BaseErrorResponse -> listener.onError(BaseResponse.throwable)
        }
        listener.onComplete()
    }
}

/**
 * StateLiveData封装，用来更新数据
 * @MainThread :主线程调用
 */
@MainThread
inline fun <T> StateLiveData<T>.observeState(
    owner: LifecycleOwner,
    listenerBuilder: ResultBuilder<T>.() -> Unit
) {
    val listener = ResultBuilder<T>().also(listenerBuilder)
    observe(owner) { BaseResponse ->
        when (BaseResponse) {
            is BaseSuccessResponse -> listener.onSuccess(BaseResponse.response)
            is BaseEmptyResponse -> listener.onDataEmpty()
            is BaseFailedResponse -> listener.onFailed(
                BaseResponse.errorCode,
                BaseResponse.errorMsg
            )
            is BaseErrorResponse -> listener.onError(BaseResponse.throwable)
        }
        listener.onComplete()
    }
}

/**
 * 请求结果构建
 */
class ResultBuilder<T> {
    var onSuccess: (data: T?) -> Unit = {}
    var onDataEmpty: () -> Unit = {}
    var onFailed: (errorCode: Int?, errorMsg: String?) -> Unit = { _, errorMsg ->
        errorMsg?.let { toast(it) }
    }
    var onError: (e: Throwable) -> Unit = { e ->
        e.message?.let { toast(it) }
    }
    var onComplete: () -> Unit = {}
}