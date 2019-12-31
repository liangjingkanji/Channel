package com.drake.channel.exmple

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.coroutines.CoroutineExceptionHandler
import kotlinx.coroutines.channels.Channel

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val handler = CoroutineExceptionHandler { coroutineContext, throwable ->
            Log.d(
                "日志",
                "(MainActivity.kt:15)    throwable = $throwable"
            )
        }

        val channel = Channel<Any>()

        tv_open.setOnClickListener {

        }

//        channel.send(23)

    }
}
