package dev.trindadedev.swupdater.utils

import android.util.Log

import java.text.SimpleDateFormat
import java.util.*

class SwLog {
  companion object {
    const val DefaultTag = "SwUpdater"
  }
  
  private val dateFormat = SimpleDateFormat("yyyy-MM-dd HH:mm:ss", Locale.getDefault())

  private fun getFormattedMessage(message: String): String {
    val timestamp = dateFormat.format(Date())
    return "[$timestamp] $message"
  }

  fun log(
    priority: Int, 
    tag: String = DefaultTag, 
    message: String
  ) {
    val formattedMessage = getFormattedMessage(message)
    when (priority) {
      Log.DEBUG -> Log.d(tag, formattedMessage)
      Log.INFO -> Log.i(tag, formattedMessage)
      Log.ERROR -> Log.e(tag, formattedMessage)
      Log.WARN -> Log.w(tag, formattedMessage)
      else -> Log.v(tag, formattedMessage)
    }
  }

  fun i(tag: String = DefaultTag, message: String) = log(Log.INFO, tag, message)
  fun d(tag: String = DefaultTag, message: String) = log(Log.DEBUG, tag, message)
  fun e(tag: String = DefaultTag, message: String) = log(Log.ERROR, tag, message)
  fun w(tag: String = DefaultTag, message: String) = log(Log.WARN, tag, message)
}