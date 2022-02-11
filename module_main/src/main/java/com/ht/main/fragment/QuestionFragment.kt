package com.ht.main.fragment

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import com.doit.base.adapter.BasePagerAdapter
import com.doit.base.fragment.BaseLazyFragment
import com.ht.main.R
import com.ht.main.databinding.FragmentQuestionBinding

class QuestionFragment : BaseLazyFragment<FragmentQuestionBinding>() {

    private val titles = ArrayList<String>(3)
    private val fragments = ArrayList<Fragment>(3)

    override fun onFirstVisibleToUser() {
        initPager();
    }

    override fun onVisibleToUser() {
    }

    override fun onInvisibleToUser() {
    }

    override fun getLayoutId(): Int {
        return R.layout.fragment_question
    }

    override fun onRetryBtnClick() {
    }

    private fun initPager() {
        fragments.add(HomeNewFragment())
        fragments.add(HomeNewFragment())
        fragments.add(HomeNewFragment())

        titles.add("推荐文章")
        titles.add("待开发")
        titles.add("待开发")
        //关联viewpager
        viewDataBinding!!.tabLayout.setupWithViewPager(viewDataBinding!!.viewPager)
        var adapter = MyAdapter(titles, childFragmentManager)
        adapter.setFragments(viewDataBinding!!.viewPager, fragments)
        viewDataBinding!!.viewPager.adapter = adapter
    }

    class MyAdapter(
        listStr: ArrayList<String>,
        fm: FragmentManager
    ) : BasePagerAdapter(fm) {
        var listStr = listStr

        override fun getPageTitle(position: Int): CharSequence? {
            return listStr[position]
        }
    }
}