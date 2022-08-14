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
import android.widget.Toast
import com.drake.channel.exmple.databinding.ActivityMainBinding
import com.drake.channel.receiveEvent
import com.drake.channel.sendEvent
import com.drake.engine.base.EngineActivity

class MainActivity : EngineActivity<ActivityMainBinding>(R.layout.activity_main) {

    override fun initView() {
        // 接收事件
        receiveEvent<String> {
            Toast.makeText(this@MainActivity, "接收到事件:  $it", Toast.LENGTH_SHORT).show()
            binding.tvEvent.text = it
        }
        // 接收标签事件
        receiveEvent<String>("标签1", "标签2") {
            Toast.makeText(this@MainActivity, "接收标签事件:  $it", Toast.LENGTH_SHORT).show()
            binding.tvEvent2.text = it
        }
        binding.btnOpenAct.setOnClickListener {
            startActivity(Intent(this@MainActivity, TestActivity::class.java))
        }
        binding.btnSendToCurrent.setOnClickListener {
            sendEvent("发送事件给当前页面")
        }
    }

    override fun initData() {
    }
}
