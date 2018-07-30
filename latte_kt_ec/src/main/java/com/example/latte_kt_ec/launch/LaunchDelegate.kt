package com.example.latte_kt_ec.launch

import android.os.Bundle
import android.view.View
import com.example.latte_kt_core.delegates.BaseDelegate
import com.example.latte_kt_core.delegates.LatteDelegate
import com.example.latte_kt_core.utils.toast
import com.example.latte_kt_ec.R
import kotlinx.android.synthetic.main.delegate_launcher.*

import kotlinx.coroutines.experimental.android.UI
import kotlinx.coroutines.experimental.delay
import kotlinx.coroutines.experimental.launch

/**
 *created on 2018/7/30
 *@author txr
 */
class LaunchDelegate : LatteDelegate() {
    override fun setLayout(): Any {
        return R.layout.delegate_launcher
    }

    override fun onBindView(rootView: View, savedInstanceState: Bundle?) {
        timeDown {
            "倒计时结束".toast()
        }

    }

    /**
     * 倒计时
     */
    private fun timeDown(callback:()->Unit){
        val job = launch(UI) {
            for (i in 5 downTo 0) {
                tv_launcher_timer.text = "$i\n跳过"
                delay(1000)
            }
            callback()
        }
        tv_launcher_timer?.setOnClickListener {
            job.cancel()
            callback()
        }
    }

}