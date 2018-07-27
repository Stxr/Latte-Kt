package com.example.xrtang.latte_kt

import android.os.Bundle
import android.view.View
import com.example.latte_kt_core.delegates.LatteDelegate
import com.example.latte_kt_core.net.IError
import com.example.latte_kt_core.net.IFailure
import com.example.latte_kt_core.net.ISuccess
import com.example.latte_kt_core.net.RestClient
import com.example.latte_kt_core.utils.toast

/**
 *created on 2018/7/26
 *@author txr
 */
class ExampleDelegate : LatteDelegate(){
    override fun setLayout(): Any {
        return R.layout.activity_example
    }

    override fun onBindView(rootView: View, savedInstanceState: Bundle?) {
        test()
    }

    fun test() = RestClient().apply {
        url = "http://www.baidu.com/"
        success = object : ISuccess {
            override fun success(response: String) {
                response.toast()
            }
        }
        failure = object : IFailure{
            override fun failure() {
                "failure".toast()
            }
        }
        error = object :IError{
            override fun error(code: Int, msg: String) {
                "error code:+$code  msg:$msg".toast()
            }
        }
    }.get()

}