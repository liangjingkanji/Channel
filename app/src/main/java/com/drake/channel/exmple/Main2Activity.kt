package com.drake.channel.exmple

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.drake.channel.send
import com.hulab.debugkit.dev

class Main2Activity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main2)

        dev {
            function("发送事件") {
                send("吴彦祖")
                log("吴彦祖")
            }
        }
    }
}
