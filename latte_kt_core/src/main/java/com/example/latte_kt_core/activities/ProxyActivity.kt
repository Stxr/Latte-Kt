package com.example.latte_kt_core.activities

import android.annotation.SuppressLint
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.ContentFrameLayout
import com.example.latte_kt_core.R
import com.example.latte_kt_core.delegates.LatteDelegate
import me.yokeyword.fragmentation.SupportActivity

/**
 *created on 2018/7/26
 *@author txr
 */
abstract class ProxyActivity : SupportActivity() {

    abstract fun setRootDelegate(): LatteDelegate

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        initContainer(savedInstanceState)
    }

    @SuppressLint("RestrictedApi")
    private fun initContainer(savedInstanceState: Bundle?) {
        val container = ContentFrameLayout(this)
        container.id = R.id.delegate_container
        setContentView(container)
        if (savedInstanceState == null) {
            loadRootFragment(R.id.delegate_container, setRootDelegate())
        }

    }
}