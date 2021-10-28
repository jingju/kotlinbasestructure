package com.doit.baselibrary.viewbinding

import android.os.Bundle
import androidx.viewbinding.ViewBinding
import com.doit.baselibrary.BaseActivity

/**
 * @author chends create on 2021/10/27.
 */
open class BaseViewBindingActivity<VB : ViewBinding> : BaseActivity() {
    protected lateinit var binding: VB

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = inflateBinding(layoutInflater)
        setContentView(binding.root)
    }

}