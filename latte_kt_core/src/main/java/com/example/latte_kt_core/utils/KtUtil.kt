package com.example.latte_kt_core.utils

import android.widget.Toast
import com.example.latte_kt_core.app.Latte

/**
 *created on 2018/7/26
 *@author txr
 */
public inline fun Boolean.isTrue(block :()->Unit):Boolean{
    if(this){
        block()
    }
    return this
}
public inline fun Boolean.isFalse(block: () -> Unit):Boolean{
    if(!this){
        block()
    }
    return this
}

public fun <T> T?.toast(duration:Int = Toast.LENGTH_SHORT){
    Toast.makeText(Latte.getApplicationContext(),this.toString(),duration).show()
}