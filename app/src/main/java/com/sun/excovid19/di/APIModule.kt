package com.sun.excovid19.di

import com.sun.excovid19.data.source.remote.utils.CovidAPIService
import org.koin.dsl.module
import retrofit2.Retrofit

val apiModule = module {
    single { get<Retrofit>().create(CovidAPIService::class.java) }
}
