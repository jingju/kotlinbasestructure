package com.doit.network.base

import com.doit.network.BuildConfig
import kotlinx.coroutines.delay

/**
 * BaseRepository
 * 网络请求的封装
 */
open class BaseRepository {

    /**
     * 用kotlin runCatching 处理异常
     * 对网络请求成功、失败的分发
     */
    suspend fun <T> executeHttp(block: suspend () -> BaseResponse<T>): BaseResponse<T> {
        //todo 测试用：模拟耗时请求
        //delay(2000)
        runCatching {
            block.invoke()
        }.onSuccess { data: BaseResponse<T> ->
            return handleHttpOk(data)
        }.onFailure { e ->
            return handleHttpError(e)
        }
        return BaseEmptyResponse()
    }

    /**
     * 非后台返回错误，捕获到的异常
     */
    private fun <T> handleHttpError(e: Throwable): BaseErrorResponse<T> {
        if (BuildConfig.DEBUG) e.printStackTrace()
        handlingExceptions(e)
        return BaseErrorResponse(e)
    }

    /**
     * 返回200，但是还要判断isSuccess
     */
    private fun <T> handleHttpOk(data: BaseResponse<T>): BaseResponse<T> {
        return if (data.isSuccess) {
            getHttpSuccessResponse(data)
        } else {
            handlingApiExceptions(data.errorCode, data.errorMsg)
            BaseFailedResponse(data.errorCode, data.errorMsg)
        }
    }

    /**
     * 成功和数据为空的处理
     */
    private fun <T> getHttpSuccessResponse(response: BaseResponse<T>): BaseResponse<T> {
        val data = response.data
        return if (data == null || data is List<*> && (data as List<*>).isEmpty()) {
            BaseEmptyResponse()
        } else {
            BaseSuccessResponse(data)
        }
    }
}