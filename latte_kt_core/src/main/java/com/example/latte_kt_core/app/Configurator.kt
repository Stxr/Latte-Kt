package com.example.latte_kt_core.app

import com.joanzapata.iconify.IconFontDescriptor
import com.joanzapata.iconify.Iconify

/**
 *created on 2018/7/25
 *@author txr
 */
object Configurator{


    val LATTE_CONFIGS: HashMap<Any, Any> = HashMap()
    var apiHost :String = ""
    var ICONS :ArrayList<IconFontDescriptor> = ArrayList()

    init {
        LATTE_CONFIGS[ConfigType.CONFIG_READY] = false
    }


//    fun withApiHost(host:String):Configurator{
//        LATTE_CONFIGS[ConfigType.API_HOST] = host
//        return this
//    }

    fun configure() {
        LATTE_CONFIGS[ConfigType.CONFIG_READY] = true
        LATTE_CONFIGS[ConfigType.API_HOST] = apiHost
        initIcons()

    }

    private fun initIcons(){
        if(ICONS.isNotEmpty()){
            val initializer = Iconify.with(ICONS[0])
            for (i in 1 until ICONS.size) {
                initializer.with(ICONS[i])
            }
        }
    }

    private fun checkConfiguration() {
        val isReady = LATTE_CONFIGS[ConfigType.CONFIG_READY] as Boolean
        if(!isReady){
            throw RuntimeException("Configuration is not ready,call configure")
        }
    }

    @Suppress("UNCHECKED_CAST")
    fun <T> getConfiguration(key:Any):T{
        checkConfiguration()
        return LATTE_CONFIGS[key] as T? ?:throw NullPointerException("$key is null")
    }


}