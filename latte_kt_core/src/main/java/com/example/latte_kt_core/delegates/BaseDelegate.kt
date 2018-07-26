package com.example.latte_kt_core.delegates

import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import me.yokeyword.fragmentation.ISupportFragment
import me.yokeyword.fragmentation.SwipeBackLayout
import me.yokeyword.fragmentation_swipeback.SwipeBackFragment


/**
 *created on 2018/7/26
 *@author txr
 */
abstract class BaseDelegate : SwipeBackFragment() {
    abstract fun setLayout(): Any
    abstract fun onBindView(rootView: View, savedInstanceState: Bundle?)
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val rootView: View = when (setLayout()) {
            is Int -> inflater.inflate(setLayout() as Int, container, false)
            is View -> setLayout() as View
            else -> throw ClassCastException("type of setLayout() must be int or view")
        }
        onBindView(rootView, savedInstanceState)
        return rootView
    }
}