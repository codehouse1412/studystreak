package com.yashica.streakpomodoro

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import android.widget.Button
import android.widget.TextView
import android.os.CountDownTimer
import java.util.concurrent.TimeUnit

class PomodoroActivity : AppCompatActivity() {
    private var timer: CountDownTimer? = null
    private var remainingMs: Long = 25 * 60 * 1000L

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_pomodoro)

        val tvTimer = findViewById<TextView>(R.id.tv_timer)
        val btnStart = findViewById<Button>(R.id.btn_start)
        val btnStop = findViewById<Button>(R.id.btn_stop)

        fun updateText(ms: Long) {
            val sec = ms / 1000
            val m = sec / 60
            val s = sec % 60
            tvTimer.text = String.format("%02d:%02d", m, s)
        }

        updateText(remainingMs)

        btnStart.setOnClickListener {
            timer?.cancel()
            timer = object : CountDownTimer(remainingMs, 1000) {
                override fun onTick(millisUntilFinished: Long) {
                    remainingMs = millisUntilFinished
                    updateText(millisUntilFinished)
                }
                override fun onFinish() {
                    updateText(0)
                    // In a full app we'd record the session time to DB and update widget
                }
            }.start()
        }

        btnStop.setOnClickListener {
            timer?.cancel()
        }
    }
}
