package com.ht.main.fragment

import com.doit.base.fragment.BaseLazyFragment
import com.ht.main.R
import com.ht.main.databinding.FragmentQuestionBinding
import com.ht.main.databinding.FragmentVideoBinding

class VideoFragment : BaseLazyFragment<FragmentVideoBinding>() {

    override fun onFirstVisibleToUser() {
    }

    override fun onVisibleToUser() {
    }

    override fun onInvisibleToUser() {
    }

    override fun getLayoutId(): Int {
        return R.layout.fragment_video
    }

    override fun onRetryBtnClick() {
    }
}