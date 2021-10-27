package com.doit.base.loadsir

import com.doit.base.R
import com.kingja.loadsir.callback.Callback

/**
 *
 * @Description:
 * @CreateDate: 2021/10/23 9:03 下午
 * @Author: yzp
 */
class EmptyCallback : Callback() {

    override fun onCreateView(): Int {
        return R.layout.base_layout_empty
    }
}