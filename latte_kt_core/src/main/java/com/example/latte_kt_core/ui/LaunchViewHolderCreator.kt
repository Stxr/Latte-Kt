package com.example.latte_kt_core.ui

import android.view.View
import com.bigkoo.convenientbanner.holder.CBViewHolderCreator
import com.bigkoo.convenientbanner.holder.Holder
import com.example.latte_kt_core.R
import com.example.latte_kt_core.ui.LaunchHolder

/**
 *created on 2018/8/1
 *@author txr
  */
class LaunchViewHolderCreator :CBViewHolderCreator{
    override fun createHolder(itemView: View?): Holder<*> {
        return LaunchHolder(itemView!!)
    }

    override fun getLayoutId(): Int {
        return R.layout.launcher_scroll
    }

}