package com.doit.base.adapter

import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentPagerAdapter

class BasePagerAdapter : FragmentPagerAdapter {

    private var mFragments = mutableListOf<Fragment>()
    private var fm: FragmentManager? = null

    constructor(fm: FragmentManager) : this(fm, BEHAVIOR_RESUME_ONLY_CURRENT_FRAGMENT)

    constructor(fm: FragmentManager, behavior: Int) : super(fm, behavior) {
        this.fm = fm;
    }

    override fun getItem(position: Int): Fragment {
        return mFragments[position]
    }

    override fun getCount(): Int {
        return mFragments.size
    }

    fun setFragments(container: ViewGroup, fragments: MutableList<Fragment>) {
        for (i in fragments.indices) {
            val fragment = findFragment(container.id, i) // 重点就是这里，会根据id去找是否有缓存的Fragment
            if (fragment != null) { // 如果有就替换，不然用户看到的，和你实际使用的会是两个不同的Fragment
                fragments[i] = fragment
            }
        }
        mFragments = fragments
    }

    private fun findFragment(viewId: Int, position: Int): Fragment? {
        val name = makeFragmentName(viewId, getItemId(position))
        return fm!!.findFragmentByTag(name)
    }

    private fun makeFragmentName(viewId: Int, id: Long): String {
        return "android:switcher:$viewId:$id"
    }
}