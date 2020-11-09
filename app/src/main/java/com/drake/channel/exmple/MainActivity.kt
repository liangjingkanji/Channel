/*
 * Copyright (C) 2018 Drake, Inc.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.drake.channel.exmple

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.drake.channel.receiveEvent
import com.drake.channel.sendEvent
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // 接收事件
        receiveEvent<String> {
            Toast.makeText(this@MainActivity, "接收到事件:  $it", Toast.LENGTH_SHORT).show()
            tv_event.text = it
        }

        btn_open_act.setOnClickListener {
            startActivity(Intent(this@MainActivity, TestActivity::class.java))
        }

        btn_send_to_current.setOnClickListener {
            sendEvent("发送事件给当前")
        }
    }
}
