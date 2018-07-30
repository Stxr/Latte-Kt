package com.example.latte_kt_ec.launch

import android.os.Bundle
import android.view.View
import com.example.latte_kt_core.delegates.BaseDelegate
import com.example.latte_kt_ec.R
import kotlinx.coroutines.experimental.android.UI
import kotlinx.coroutines.experimental.launch

/**
 *created on 2018/7/30
 *@author txr
 */
class LaunchDelegate :BaseDelegate(){
    override fun setLayout(): Any {
        return R.layout.delegate_launcher
    }

    override fun onBindView(rootView: View, savedInstanceState: Bundle?) {
//        launch(UI) {
//            for(i in 5 downTo 0){
////                tv_launcher_timer.text = ""
//            }
//        }
    }

}