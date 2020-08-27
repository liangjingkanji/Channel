package com.drake.channel.exmple

import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.drake.channel.sendEvent
import kotlinx.android.synthetic.main.activity_main2.*

class Main2Activity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main2)

        btn_send_event.setOnClickListener {
            val event = et_event.text.toString()
            if (event.isBlank()) {
                Toast.makeText(this, "请输入事件内容", Toast.LENGTH_SHORT).show()
            } else {
                sendEvent(event)
                Toast.makeText(this, "发送成功", Toast.LENGTH_SHORT).show()
            }
        }
    }
}
