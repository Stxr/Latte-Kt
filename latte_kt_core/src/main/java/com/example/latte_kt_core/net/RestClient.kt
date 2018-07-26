package com.example.latte_kt_core.net

import okhttp3.RequestBody
import retrofit2.Call
import java.util.*

/**
 *created on 2018/7/26
 *@author txr
 */
class RestClient {
    lateinit var url: String
    var request :IRequest?=null
    lateinit var success :ISuccess
    lateinit var error: IError
    lateinit var failure :IFailure
    lateinit var name :String
    lateinit var body: RequestBody
    var params = WeakHashMap<String,Any>()

    private fun request(method: HttpMethod){
        val service = RestCreator.restService
        request?.onRequestStart()
        when(method){
            HttpMethod.DELETE  -> service.put(url,params)
            HttpMethod.GET -> service.get(url,params)
            HttpMethod.PUT -> service.put(url,params)
            HttpMethod.POST -> service.post(url,params)
            HttpMethod.POST_RAW -> service.postRaw(url,body)
            HttpMethod.PUT_RAW -> service.putRaw(url,body)
            HttpMethod.UPLOAD -> service.putRaw(url,body)
            else -> service.putRaw(url,body)
        }.enqueue(getRestCallback())

    }

    public fun get(){
        request(HttpMethod.GET)
    }

    private fun getRestCallback(): RestClientCallback {
        return RestClientCallback(success,error,request, failure)
    }

}