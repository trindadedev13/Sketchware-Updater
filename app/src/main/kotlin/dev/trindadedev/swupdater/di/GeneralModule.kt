package dev.trindadedev.swupdater.di

import dev.trindadedev.swupdater.ui.screens.home.HomeViewModel

import org.koin.androidx.viewmodel.dsl.viewModelOf
import org.koin.core.module.dsl.singleOf
import org.koin.dsl.module

/*
 * General Module
 */
val GeneralModule = module {
  viewModelOf(::HomeViewModel)
}
