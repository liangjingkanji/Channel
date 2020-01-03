package com.drake.channel.exmple

import android.content.Intent
import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import com.drake.channel.receive
import com.drake.channel.send
import com.hulab.debugkit.dev
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        receive<String>(true) {

            Log.d("日志", "(MainActivity.kt:25)    事件 = $it")

            tv.text = it
        }





        dev {
            function("新界面") {
                startActivity(Intent(this@MainActivity, Main2Activity::class.java))
            }

            function("发送事件") {
                send("金城武")
                log("金城武")
            }
        }
    }
}
