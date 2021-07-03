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

import android.widget.Toast
import com.drake.channel.exmple.databinding.ActivityTestBinding
import com.drake.channel.sendEvent
import com.drake.engine.base.EngineActivity

class TestActivity : EngineActivity<ActivityTestBinding>(R.layout.activity_test) {

    override fun initView() {
        binding.btnSendEvent.setOnClickListener {
            val event = binding.etEvent.text.toString()
            if (event.isBlank()) {
                Toast.makeText(this, "请输入事件内容", Toast.LENGTH_SHORT).show()
            } else {
                sendEvent(event)
            }
        }
    }

    override fun initData() {
    }
}
