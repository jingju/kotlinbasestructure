package com.ht.main.fragment

import com.doit.base.fragment.BaseLazyFragment
import com.ht.main.R
import com.ht.main.databinding.FragmentCourseBinding
import com.ht.main.databinding.FragmentQuestionBinding
import com.ht.main.databinding.FragmentVideoBinding

class CourseFragment : BaseLazyFragment<FragmentCourseBinding>() {

    override fun onFirstVisibleToUser() {
    }

    override fun onVisibleToUser() {
    }

    override fun onInvisibleToUser() {
    }

    override fun getLayoutId(): Int {
        return R.layout.fragment_course
    }

    override fun onRetryBtnClick() {
    }
}