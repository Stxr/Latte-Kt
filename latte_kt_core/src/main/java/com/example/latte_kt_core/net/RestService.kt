package com.example.latte_kt_core.net

import okhttp3.MultipartBody
import okhttp3.RequestBody
import okhttp3.ResponseBody
import retrofit2.Call
import retrofit2.http.*
import java.util.*

/**
 *created on 2018/7/26
 *@author txr
 */
interface RestService {
    @GET
    fun get(@Url url: String, @QueryMap params: WeakHashMap<String, Any>): Call<String>

    @FormUrlEncoded
    @PUT
    fun put(@Url url: String, @FieldMap params: WeakHashMap<String, Any>): Call<String>

    @PUT
    fun putRaw(@Url url: String, @Body body: RequestBody): Call<String>

    @FormUrlEncoded
    @POST
    fun post(@Url url: String, @FieldMap params: WeakHashMap<String, Any>): Call<String>

    @POST
    fun postRaw(@Url url: String, @Body body: RequestBody): Call<String>

    @Streaming
    @GET
    fun download(@Url url: String, @QueryMap params: WeakHashMap<String, Any>): Call<ResponseBody>

    @DELETE
    fun delete(@Url url: String, @QueryMap params: WeakHashMap<String, Any>)

    @Multipart
    @POST
    fun upload(@Url url: String, @Part file: MultipartBody.Part)

}