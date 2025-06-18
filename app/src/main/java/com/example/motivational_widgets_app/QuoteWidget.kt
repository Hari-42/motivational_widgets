package com.example.motivational_widgets_app

import android.app.PendingIntent
import android.appwidget.AppWidgetManager
import android.appwidget.AppWidgetProvider
import android.content.Context
import android.content.Intent
import android.content.SharedPreferences
import android.os.Bundle
import android.util.TypedValue
import android.widget.RemoteViews

class QuoteWidget : AppWidgetProvider() {

    companion object {
        const val ACTION_REFRESH_QUOTE = "com.example.motivational_widgets_app.REFRESH_QUOTE"
        const val PREFS_NAME = "QuoteWidgetPrefs"
        const val PREF_PREFIX_KEY_TEXT = "quote_text_"
        const val PREF_PREFIX_KEY_AUTHOR = "quote_author_"
    }

    override fun onUpdate(context: Context, appWidgetManager: AppWidgetManager, appWidgetIds: IntArray) {
        for (appWidgetId in appWidgetIds) {
            updateWidget(context, appWidgetManager, appWidgetId, null, refresh = false)
        }
    }

    override fun onAppWidgetOptionsChanged(
        context: Context,
        appWidgetManager: AppWidgetManager,
        appWidgetId: Int,
        newOptions: Bundle
    ) {
        updateWidget(context, appWidgetManager, appWidgetId, newOptions, refresh = false)
    }

    override fun onReceive(context: Context, intent: Intent) {
        super.onReceive(context, intent)

        if (intent.action == ACTION_REFRESH_QUOTE) {
            val appWidgetId = intent.getIntExtra(AppWidgetManager.EXTRA_APPWIDGET_ID, AppWidgetManager.INVALID_APPWIDGET_ID)
            if (appWidgetId != AppWidgetManager.INVALID_APPWIDGET_ID) {
                val appWidgetManager = AppWidgetManager.getInstance(context)
                updateWidget(context, appWidgetManager, appWidgetId, null, refresh = true)
            }
        }
    }

    private fun updateWidget(
        context: Context,
        appWidgetManager: AppWidgetManager,
        appWidgetId: Int,
        options: Bundle?,
        refresh: Boolean
    ) {
        val prefs = context.getSharedPreferences(PREFS_NAME, Context.MODE_PRIVATE)
        val views = RemoteViews(context.packageName, R.layout.quote_widget)

        // Get widget size
        val actualOptions = options ?: appWidgetManager.getAppWidgetOptions(appWidgetId)
        val minHeight = actualOptions.getInt(AppWidgetManager.OPTION_APPWIDGET_MIN_HEIGHT, 70)
        val textSize = when {
            minHeight < 80 -> 10f
            minHeight < 140 -> 14f
            else -> 18f
        }

        // Load or refresh quote
        val quote = if (refresh) {
            val newQuote = sampleQuotes.random()
            prefs.edit().apply {
                putString(PREF_PREFIX_KEY_TEXT + appWidgetId, newQuote.text)
                putString(PREF_PREFIX_KEY_AUTHOR + appWidgetId, newQuote.author)
                apply()
            }
            newQuote
        } else {
            val text = prefs.getString(PREF_PREFIX_KEY_TEXT + appWidgetId, sampleQuotes[0].text) ?: sampleQuotes[0].text
            val author = prefs.getString(PREF_PREFIX_KEY_AUTHOR + appWidgetId, sampleQuotes[0].author) ?: sampleQuotes[0].author
            Quote(author, text)
        }

        // Set content
        views.setTextViewText(R.id.quote_text, "\"${quote.text}\"")
        views.setTextViewText(R.id.quote_author, "- ${quote.author}")
        views.setTextViewTextSize(R.id.quote_text, TypedValue.COMPLEX_UNIT_SP, textSize)

        // Click intent to refresh
        val intent = Intent(context, QuoteWidget::class.java).apply {
            action = ACTION_REFRESH_QUOTE
            putExtra(AppWidgetManager.EXTRA_APPWIDGET_ID, appWidgetId)
        }

        val pendingIntent = PendingIntent.getBroadcast(
            context,
            appWidgetId,
            intent,
            PendingIntent.FLAG_UPDATE_CURRENT or PendingIntent.FLAG_IMMUTABLE
        )
        views.setOnClickPendingIntent(R.id.widget_root, pendingIntent)

        appWidgetManager.updateAppWidget(appWidgetId, views)
    }
}