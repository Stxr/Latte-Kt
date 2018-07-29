package com.example.xrtang.latte_kt

import android.os.Bundle
import android.view.View
import com.example.latte_kt_core.delegates.LatteDelegate
import com.example.latte_kt_core.net.*
import com.example.latte_kt_core.utils.toast

/**
 *created on 2018/7/26
 *@author txr
 */
class ExampleDelegate : LatteDelegate() {
    override fun setLayout(): Any {
        return R.layout.activity_example
    }

    override fun onBindView(rootView: View, savedInstanceState: Bundle?) {
        test()
    }

    fun test() = RestClient().apply {
        url = "http://www.baidu.com/"
        success = { msg -> msg.toast() }
        failure = { "failure".toast() }
        error = { code: Int, msg: String -> "error code:+$code  msg:$msg".toast() }
        request = object :IRequest{
            override fun onRequestStart() {
                TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
            }

            override fun onRequestEnd() {
                TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
            }

        }
    }.get()

}