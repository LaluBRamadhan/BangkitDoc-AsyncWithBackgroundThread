package com.code.backgorundthread

import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.lifecycleScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val btnStart: Button = findViewById(R.id.btn_start)
        val tvStatus: TextView = findViewById(R.id.tv_status)
        

        btnStart.setOnClickListener{
            lifecycleScope.launch(Dispatchers.Default) {
                for (i in 1..10){
                    delay(500)
                    val percentage = i * 10
                    withContext(Dispatchers.Main){
                        if (percentage == 100){
                            tvStatus.setText(R.string.task_completed)
                        }else{
                            tvStatus.text = String.format(getString(R.string.compressing), percentage)
                        }
                    }
                }
            }
        }
    }
}