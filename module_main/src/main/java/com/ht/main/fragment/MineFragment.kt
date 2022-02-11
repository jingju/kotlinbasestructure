package com.ht.main.fragment

import com.doit.base.fragment.BaseLazyFragment
import com.ht.main.R
import com.ht.main.databinding.FragmentMineBinding
import com.ht.main.databinding.FragmentQuestionBinding
import com.ht.main.databinding.FragmentVideoBinding

class MineFragment : BaseLazyFragment<FragmentMineBinding>() {

    override fun onFirstVisibleToUser() {
    }

    override fun onVisibleToUser() {
    }

    override fun onInvisibleToUser() {
    }

    override fun getLayoutId(): Int {
        return R.layout.fragment_mine
    }

    override fun onRetryBtnClick() {
    }
}