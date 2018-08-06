package com.example.latte_kt_ec.launch

import android.os.Bundle
import android.view.View
import com.bigkoo.convenientbanner.ConvenientBanner
import com.example.latte_kt_core.delegates.LatteDelegate
import com.example.latte_kt_core.ui.LaunchViewHolderCreator
import com.example.latte_kt_core.utils.isTrue
import com.example.latte_kt_core.utils.toast
import com.example.latte_kt_ec.R

/**
 *created on 2018/8/1
 *@author txr
 */
class LaunchScrollerDelegate : LatteDelegate() {
    private var convenientBanner: ConvenientBanner<Int>? = null

    override fun onBindView(rootView: View, savedInstanceState: Bundle?) {
        convenientBanner?.run {
            setPages(LaunchViewHolderCreator(),
                    arrayListOf(R.mipmap.launcher_01,
                    R.mipmap.launcher_02,
                    R.mipmap.launcher_03,
                    R.mipmap.launcher_04,
                    R.mipmap.launcher_05))
            setPageIndicator(intArrayOf(R.drawable.dot_normal, R.drawable.dot_focus))
            setPageIndicatorAlign(ConvenientBanner.PageIndicatorAlign.CENTER_HORIZONTAL)
            isCanLoop = false
            setOnItemClickListener{
                (it == 4).isTrue { isFirstLaunch = false }
            }
        }
    }

    override fun setLayout(): Any {
        convenientBanner = ConvenientBanner(activity)
        return convenientBanner as ConvenientBanner<Int>
    }


}