package com.doit.networklibrary

import androidx.lifecycle.Observer

open class MultiStateObserver<T> : Observer<BaseResponse<T>>{


    override fun onChanged(t: BaseResponse<T>?) {
        /**
         * 1、请求成功的回调
         * 2、请求失败的回调
         * 3、数据为null或者为空的回调
         */
        when(t?.state){
                0->{//失败
                    onFailed()
                }

               1->{//成功
                   onDataChange(t.data)
               }
        }

    }

    /**
     * 请求数据且数据不为空
     */
    open fun onDataChange(data: T?) {//qing

    }

    fun onFailed(){

    }


}