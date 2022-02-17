package com.ht.main.fragment

import com.doit.base.fragment.BaseLazyFragment
import com.ht.main.R
import com.ht.main.databinding.MainFragmentMineBinding

class MineFragment : BaseLazyFragment<MainFragmentMineBinding>() {

    override fun onFirstVisibleToUser() {
    }

    override fun onVisibleToUser() {
    }

    override fun onInvisibleToUser() {
    }

    override fun getLayoutId(): Int {
        return R.layout.main_fragment_mine
    }

    override fun onRetryBtnClick() {
    }
}