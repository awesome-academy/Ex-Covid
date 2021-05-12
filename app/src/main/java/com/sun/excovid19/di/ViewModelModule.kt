package com.sun.excovid19.di

import com.sun.excovid19.ui.home.HomeViewModel
import com.sun.excovid19.ui.location.LocationViewModel
import com.sun.excovid19.ui.news.NewsViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val viewModelModule = module {
    viewModel { HomeViewModel(get()) }
    viewModel { LocationViewModel(get()) }
    viewModel { NewsViewModel(get()) }
}
