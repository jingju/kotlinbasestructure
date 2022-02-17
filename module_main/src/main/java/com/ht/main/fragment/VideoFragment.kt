package com.ht.main.fragment

import com.doit.base.fragment.BaseLazyFragment
import com.ht.main.R
import com.ht.main.databinding.MainFragmentVideoBinding

class VideoFragment : BaseLazyFragment<MainFragmentVideoBinding>() {

    override fun onFirstVisibleToUser() {
    }

    override fun onVisibleToUser() {
    }

    override fun onInvisibleToUser() {
    }

    override fun getLayoutId(): Int {
        return R.layout.main_fragment_video
    }

    override fun onRetryBtnClick() {
    }
}