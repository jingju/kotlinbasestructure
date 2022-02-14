package com.doit.base.utils

import android.content.Context
import android.text.TextUtils
import android.widget.Toast

object ToastUtils {
    var mToast: Toast? = null

    fun show(context: Context, msg: String?) {
        try {
            if (!TextUtils.isEmpty(msg)) {
                mToast?.cancel()
                mToast = Toast.makeText(context, "", Toast.LENGTH_LONG)
                mToast!!.setText(msg)
                mToast!!.show()
            }
        } catch (e: Exception) {
            e.printStackTrace()
        }
    }
}