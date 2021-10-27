package com.doit.network.utils

import com.jeremyliao.liveeventbus.LiveEventBus

const val SHOW_TOAST = "show_toast"

/**
 * LiveEventBus Android消息总线，基于LiveData，具有生命周期感知能力
 */
fun toast(msg: String) {
    LiveEventBus.get<String>(SHOW_TOAST).post(msg)
}