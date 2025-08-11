package com.yashica.streakpomodoro

import android.app.AlertDialog
import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import android.widget.Button
import android.widget.TextView
import java.util.concurrent.TimeUnit

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val tv = findViewById<TextView>(R.id.tv_today_hours)
        val btn = findViewById<Button>(R.id.btn_open_pomodoro)

        // For demo, we show 40 minutes studied; in real app this will read from Room DB
        val minutes = 40
        val hours = minutes / 60
        val mins = minutes % 60
        tv.text = "Today's studied: ${hours}h ${mins}m"

        // Show warning popup if < 1hr and after 9 PM (simple demo check)
        val hourOfDay = java.util.Calendar.getInstance().get(java.util.Calendar.HOUR_OF_DAY)
        if (minutes < 60 && hourOfDay >= 21) {
            AlertDialog.Builder(this)
                .setTitle("⚠ Streak at risk")
                .setMessage("You haven't reached your 1-hour goal today! Your streak will reset at midnight.")
                .setPositiveButton("Start Timer Now") { _, _ ->
                    startActivity(Intent(this, PomodoroActivity::class.java))
                }
                .setNegativeButton("Dismiss", null)
                .show()
        }

        btn.setOnClickListener {
            startActivity(Intent(this, PomodoroActivity::class.java))
        }
    }
}
