package com.manishwarade.inf.adapter

import android.util.SparseArray
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentStatePagerAdapter
import java.lang.ref.WeakReference

class NewsFragmentStateAdapter(fm: FragmentManager, private val mTabHeader: Array<String>, private val fragments: Array<Fragment>, private val count: Int) : FragmentStatePagerAdapter(fm) {

    private val instantiatedFragments = SparseArray<WeakReference<Fragment>>()

    override fun getItem(position: Int): Fragment {

        return fragments[position]
    }

    override fun getCount(): Int {
        return count
    }

    override fun instantiateItem(container: ViewGroup, position: Int): Any {
        val fragment = super.instantiateItem(container, position) as Fragment
        instantiatedFragments.put(position, WeakReference(fragment))
        return fragment
    }

    override fun destroyItem(container: View, position: Int, `object`: Any) {
        instantiatedFragments.remove(position)
        super.destroyItem(container, position, `object`)
    }

    fun getFragment(position: Int): Fragment? {
        val wr = instantiatedFragments.get(position)
        return wr?.get()
    }

    override fun getPageTitle(position: Int): CharSequence? {
        return mTabHeader[position]
    }
}