package com.example.latte_kt_core.delegates

import com.example.latte_kt_core.ui.LaunchType
import com.example.latte_kt_core.utils.LattePreference

/**
 *created on 2018/7/26
 *@author txr
 */

abstract class LatteDelegate : PermissionCheckDelegate() {
    protected var isFirstLaunch :Boolean by LattePreference(LaunchType.IS_FIRST_LAUNCH.name,true)
}
