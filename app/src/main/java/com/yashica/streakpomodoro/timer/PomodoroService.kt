package com.yashica.streakpomodoro.timer

import android.app.Service
import android.content.Intent
import android.os.IBinder

class PomodoroService : Service() {
    override fun onBind(intent: Intent?): IBinder? = null
}
