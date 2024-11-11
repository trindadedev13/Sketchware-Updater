package dev.trindadedev.swupdater

import android.app.Application

import dev.trindadedev.swupdater.di.GeneralModule

import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin

class SwUpdaterApp: Application() {

  override fun onCreate() {
    super.onCreate()
    configureKoin()
  }

  /*
   * Start koin for dependency injection
   */
  fun configureKoin() {
    startKoin {
      androidContext(this@SwUpdaterApp)
      modules(GeneralModule)
    }
  }
}
