package com.example.motivational_widgets_app

import android.app.PendingIntent
import android.appwidget.AppWidgetManager
import android.appwidget.AppWidgetProvider
import android.content.Context
import android.content.Intent
import android.widget.RemoteViews
import kotlin.random.Random

class QuoteWidget : AppWidgetProvider() {

    private val quotes = listOf(
        Quote("Nelson Mandela", "It always seems impossible until it’s done."),
        Quote("Tony Robbins", "The only limit to your impact is your imagination and commitment."),
        Quote("Steve Jobs", "Stay hungry, stay foolish."),
        Quote("Zig Ziglar", "You don’t have to be great to start, but you have to start to be great."),
        Quote("Maya Angelou", "You will face many defeats in life, but never let yourself be defeated.")
    )

    override fun onUpdate(context: Context, appWidgetManager: AppWidgetManager, appWidgetIds: IntArray) {
        for (appWidgetId in appWidgetIds) {
            updateAppWidget(context, appWidgetManager, appWidgetId)
        }
    }

    private fun updateAppWidget(context: Context, appWidgetManager: AppWidgetManager, appWidgetId: Int) {
        val views = RemoteViews(context.packageName, R.layout.quote_widget)

        val quote = quotes.random()
        views.setTextViewText(R.id.quote_text, "\"${quote.text}\"")
        views.setTextViewText(R.id.quote_author, "- ${quote.author}")

        // Setup refresh button
        val intent = Intent(context, QuoteWidget::class.java).apply {
            action = AppWidgetManager.ACTION_APPWIDGET_UPDATE
            putExtra(AppWidgetManager.EXTRA_APPWIDGET_IDS, intArrayOf(appWidgetId))
        }
        val pendingIntent = PendingIntent.getBroadcast(context, appWidgetId, intent, PendingIntent.FLAG_UPDATE_CURRENT or PendingIntent.FLAG_IMMUTABLE)
        views.setOnClickPendingIntent(R.id.refresh_button, pendingIntent)

        appWidgetManager.updateAppWidget(appWidgetId, views)
    }
}
