package com.example.latte_kt_core.ui

import android.support.v7.widget.AppCompatImageView
import android.view.View
import com.bigkoo.convenientbanner.holder.Holder
import com.example.latte_kt_core.R


/**
 *created on 2018/8/1
 *@author txr
 */
class LaunchHolder( itemView: View) : Holder<Int>(itemView) {
    lateinit var imageView: AppCompatImageView
    override fun updateUI(data: Int?) {
        imageView.setBackgroundResource(data!!)
    }

    override fun initView(itemView: View?) {
        imageView = itemView?.findViewById(R.id.launcher_scroll_iv)!!
    }

}