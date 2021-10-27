package com.doit.base.loadsir

import android.content.Context
import android.view.View
import com.doit.base.R
import com.kingja.loadsir.callback.Callback

/**
 *
 * @Description:
 * @CreateDate: 2021/10/23 8:58 下午
 * @Author: yzp
 */
class LoadingCallback : Callback() {

    override fun onCreateView(): Int {
        return R.layout.base_layout_loading
    }

    override fun getSuccessVisible(): Boolean {
        return super.getSuccessVisible()
    }

    override fun onReloadEvent(context: Context?, view: View?): Boolean {
        return true
    }
}