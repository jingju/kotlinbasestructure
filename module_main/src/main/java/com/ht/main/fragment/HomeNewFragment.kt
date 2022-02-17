package com.ht.main.fragment

import com.doit.base.fragment.BaseLazyFragment
import com.ht.main.R
import com.ht.main.databinding.MainFragmentCourseBinding

class HomeNewFragment : BaseLazyFragment<MainFragmentCourseBinding>() {

    override fun onFirstVisibleToUser() {
    }

    override fun onVisibleToUser() {
    }

    override fun onInvisibleToUser() {
    }

    override fun getLayoutId(): Int {
        return R.layout.main_fragment_course
    }

    override fun onRetryBtnClick() {
    }
}