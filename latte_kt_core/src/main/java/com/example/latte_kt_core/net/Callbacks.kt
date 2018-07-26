package com.example.latte_kt_core.net

import com.example.latte_kt_core.utils.isTrue
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

/**
 *created on 2018/7/26
 *@author txr
 */
interface ISuccess {
    fun success(response: String)
}

interface IError {
    fun error(code: Int, msg: String)
}

interface IFailure {
    fun failure()
}

interface IRequest {
    fun onRequestStart()
    fun onRequestEnd()
}

class RestClientCallback(
        private val success: ISuccess,
        private val error: IError,
        private val request: IRequest?,
        private val failure: IFailure
) : Callback<String> {

    override fun onResponse(call: Call<String>?, response: Response<String>?) {
        response!!.isSuccessful.isTrue {
            if(call!!.isExecuted){
                success.success(response.body()!!)
            }else{
                error.error(response.code(), response.message())
            }
        }
        request?.onRequestEnd()
    }

    override fun onFailure(call: Call<String>?, t: Throwable?) {
        failure.failure()
        request?.onRequestEnd()
    }

}
