package com.doit.network.base

import java.io.Serializable

/**
 *
 * BaseResponse基类
 */
open class BaseResponse<T>(
    open val data: T? = null,
    open val errorCode: Int? = null,
    open val errorMsg: String? = null,
    open val error: Throwable? = null,
) : Serializable { //todo Parcelable 性能更优，待优化
    val isSuccess: Boolean
        get() = errorCode == 0
}

data class BaseSuccessResponse<T>(val response: T) : BaseResponse<T>(data = response)

class BaseEmptyResponse<T> : BaseResponse<T>()

data class BaseFailedResponse<T>(override val errorCode: Int?, override val errorMsg: String?) :
    BaseResponse<T>(errorCode = errorCode, errorMsg = errorMsg)

data class BaseErrorResponse<T>(val throwable: Throwable) : BaseResponse<T>(error = throwable)
