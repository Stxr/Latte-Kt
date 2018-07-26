package com.example.latte_kt_core.net

import com.example.latte_kt_core.app.ConfigType
import com.example.latte_kt_core.app.Latte
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.scalars.ScalarsConverterFactory

/**
 *created on 2018/7/26
 *@author txr
 */
object RestCreator{
    private val baseUrl:String = Latte.getConfiguration(ConfigType.API_HOST)
    val restService: RestService = Retrofit.Builder().apply {
        baseUrl(baseUrl)
        client(OkHttpClient())
        addConverterFactory(ScalarsConverterFactory.create())
    }.build().create(RestService::class.java)

}