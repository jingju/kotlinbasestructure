package com.doit.base.utils

import androidx.lifecycle.lifecycleScope
import com.doit.base.activity.BaseActivity
import com.doit.network.base.*
import com.doit.network.observer.ResultBuilder
import kotlinx.coroutines.InternalCoroutinesApi
import kotlinx.coroutines.flow.*
import kotlinx.coroutines.launch

/**
 * MvvmBaseActivity工具类，主要解决模板代码问题
 * 解决Flow loading模板代码
 * 解决BaseResponse解析模板代码
 * Flow：异步构建，HTTP请求自动对loading处理；去除LiveData重复声明
 * lifecycleScope: 携程作用域 监听Activity生命周期 不会造成内存泄漏
 */

/**
 * 封装Loading的普通方法，不返回任何实体类
 */
fun <T> BaseActivity<*>.launchWithLoading(requestBlock: suspend () -> Unit) {
    lifecycleScope.launch {
        flow {
            emit(requestBlock())
        }.onStart {
            showLoading()
        }.onCompletion {
            dismissLoading()
        }.collect()
    }
}

/**
 * 请求不带Loading
 * 不需要声明LiveData
 */
@OptIn(InternalCoroutinesApi::class)
fun <T> BaseActivity<*>.launchAndCollect(
    requestBlock: suspend () -> BaseResponse<T>,
    listenerBuilder: ResultBuilder<T>.() -> Unit
) {
    lifecycleScope.launch {
        launchFlow(requestBlock)
            .collect { response ->
                parseResultAndCallback(response, listenerBuilder)
            }
    }
}

/**
 * 请求带Loading
 * 不需要声明LiveData
 */
fun <T> BaseActivity<*>.launchWithLoadingAndCollect(
    requestBlock: suspend () -> BaseResponse<T>,
    listenerBuilder: ResultBuilder<T>.() -> Unit
) {
    lifecycleScope.launch {
        launchFlow(requestBlock, {
            showLoading()
        }, {
            dismissLoading()
        }).collect { response ->
            parseResultAndCallback(response, listenerBuilder)
        }
    }
}

/**
 * flow 简单封装，callback存在则执行
 * 实现在请求前后并不一定是loading，所以自己扩展Callback
 */
fun <T> launchFlow(
    requestBlock: suspend () -> BaseResponse<T>,
    startCallback: (() -> Unit)? = null,
    completeCallback: (() -> Unit)? = null
): Flow<BaseResponse<T>> {
    return flow {
        emit(requestBlock())
    }.onStart {
        startCallback?.invoke()
    }.onCompletion {
        completeCallback?.invoke()
    }
}

/**
 * 解析返回结果
 * 根据不同返回结果执行不同的 ResultBuilder
 */
private fun <T> parseResultAndCallback(
    response: BaseResponse<T>,
    listenerBuilder: ResultBuilder<T>.() -> Unit
) {
    val listener = ResultBuilder<T>().also(listenerBuilder)
    when (response) {
        is BaseSuccessResponse -> listener.onSuccess(response.response)
        is BaseEmptyResponse -> listener.onDataEmpty()
        is BaseFailedResponse -> listener.onFailed(response.errorCode, response.errorMsg)
        is BaseErrorResponse -> listener.onError(response.throwable)
    }
    listener.onComplete()
}