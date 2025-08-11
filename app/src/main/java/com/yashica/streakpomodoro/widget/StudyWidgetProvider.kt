package com.yashica.streakpomodoro.widget

import android.app.PendingIntent
import android.appwidget.AppWidgetManager
import android.appwidget.AppWidgetProvider
import android.content.ComponentName
import android.content.Context
import android.content.Intent
import android.widget.RemoteViews
import com.yashica.streakpomodoro.MainActivity
import com.yashica.streakpomodoro.R

class StudyWidgetProvider : AppWidgetProvider() {
    override fun onUpdate(context: Context, appWidgetManager: AppWidgetManager, appWidgetIds: IntArray) {
        val views = RemoteViews(context.packageName, R.layout.widget_small)
        // For demo we use static values. In a full app we'd read DB and update values.
        views.setTextViewText(R.id.tv_streak, "🔥 3")
        views.setTextViewText(R.id.tv_hours, "⏳ 1h 10m")
        val intent = Intent(context, MainActivity::class.java)
        val pi = PendingIntent.getActivity(context, 0, intent, PendingIntent.FLAG_UPDATE_CURRENT or PendingIntent.FLAG_IMMUTABLE)
        views.setOnClickPendingIntent(R.id.widget_root, pi)

        // Update all widgets
        val thisWidget = ComponentName(context, StudyWidgetProvider::class.java)
        appWidgetManager.updateAppWidget(thisWidget, views)
    }
}
