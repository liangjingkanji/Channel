package com.drake.channel.exmple

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Lifecycle
import com.drake.channel.receiveEvent
import com.drake.channel.sendEvent
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // 接收事件
        receiveEvent<String>(lifecycleEvent = Lifecycle.Event.ON_PAUSE) {
            tv_event.text = it
        }

        btn_open_act.setOnClickListener {
            startActivity(Intent(this@MainActivity, Main2Activity::class.java))
        }

        btn_send_to_current.setOnClickListener {
            sendEvent("发送事件给当前")
        }
    }
}
