package com.example.xrtang.latte_kt

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import com.example.latte_kt_core.activities.ProxyActivity
import com.example.latte_kt_core.delegates.LatteDelegate
import com.example.latte_kt_ec.launch.LaunchDelegate

class ExampleActivity : ProxyActivity() {
    override fun setRootDelegate(): LatteDelegate {
        return LaunchDelegate()
    }
}
