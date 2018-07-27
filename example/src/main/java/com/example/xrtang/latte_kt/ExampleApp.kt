package com.example.xrtang.latte_kt

import android.app.Application
import com.example.latte_kt_core.app.Latte
import com.joanzapata.iconify.fonts.FontAwesomeIcons
import com.joanzapata.iconify.fonts.FontAwesomeModule

/**
 *created on 2018/7/26
 *@author txr
 */

class ExampleApp : Application() {
    override fun onCreate() {
        super.onCreate()
//        Latte.init(this)
//                .withApiHost("http://127.0.0.1/")
//                .configure()
        Latte.init(this).apply {
            apiHost = "http://127.0.0.1/"
            ICONS = arrayListOf(FontAwesomeModule())
        }.configure()
    }
}
