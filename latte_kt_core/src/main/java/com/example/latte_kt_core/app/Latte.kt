package com.example.latte_kt_core.app

import android.content.Context

/**
 *created on 2018/7/25
 *@author txr
 */

object Latte {
    fun init(context: Context): Configurator {
         Configurator.LATTE_CONFIGS[ConfigType.APPLICATION_CONTEXT] = context.applicationContext
         return Configurator
     }
    fun getApplicationContext():Context{
        return getConfiguration(ConfigType.APPLICATION_CONTEXT)
    }

    fun getConfigurator(): Configurator = Configurator

    fun <T> getConfiguration(key: Any): T {
       return getConfigurator().getConfiguration(key)
    }
}