package com.example.latte_kt_core.utils

import android.content.SharedPreferences
import android.preference.PreferenceManager
import com.example.latte_kt_core.app.Latte
import java.io.ByteArrayInputStream
import java.io.ByteArrayOutputStream
import java.io.ObjectInputStream
import java.io.ObjectOutputStream
import kotlin.reflect.KProperty

/**
 *created on 2018/8/1
 *@author txr
 */
class LattePreference<T>(val key: String, val value: T) {
    companion object {
        private val ref: SharedPreferences by lazy {
            PreferenceManager.getDefaultSharedPreferences(Latte.getApplicationContext())
        }

    }

    operator fun getValue(thisRef: Any, property: KProperty<*>): T {
       return get(key,value)
    }

    operator fun setValue(thisRef: Any, property: KProperty<*>, value: T) {
        put(key,value)
    }

    private fun put(key: String, value: T) = with(ref.edit()) {
        when (value) {
            is String -> putString(key, value)
            is Boolean -> putBoolean(key, value)
            is Float -> putFloat(key, value)
            is Long -> putLong(key, value)
            is Int -> putInt(key,value)
            else -> putString(key,serialize(value))
        }.apply()
    }
    @Suppress("UNCHECKED_CAST")
    private fun get(key: String, default: T) :T = ref.run {
       val res :Any =  when (default) {
            is String -> getString(key, default)
            is Boolean -> getBoolean(key, default)
            is Float -> getFloat(key, default)
            is Long -> getLong(key, default)
            is Int -> getInt(key,default)
            else -> deserialize(getString(key,serialize(default)))
        }
        return res as T
    }

    /**
     * 序列化
     */

    private fun <A> serialize(a:A):String{
        val outputStream = ByteArrayOutputStream()
        val objectOutputStream = ObjectOutputStream(outputStream)
        objectOutputStream.writeObject(a)
        var string = outputStream.toString("ISO-8859-1")
        string = java.net.URLEncoder.encode(string,"utf-8")
        outputStream.close()
        objectOutputStream.close()
        return string
    }

    /**
     * 反序列化
     */

    @Suppress("UNCHECKED_CAST")
    private fun <A> deserialize(str:String):A{
        val decode = java.net.URLDecoder.decode(str, "utf-8")
        val inputStream = ByteArrayInputStream(decode.toByteArray(charset("iso-8859-1")))
        val objectInputStream = ObjectInputStream(inputStream)
        val obj = objectInputStream.readObject() as A
        objectInputStream.close()
        inputStream.close()
        return obj
    }

}