package com.sun.excovid19.di

import com.sun.excovid19.data.source.remote.utils.CovidAPIService
import com.sun.excovid19.data.source.remote.utils.CovidNewsService
import com.sun.excovid19.utils.AppConstant
import org.koin.core.qualifier.named
import org.koin.dsl.module
import retrofit2.Retrofit

val apiModule = module {
    single(named(AppConstant.COVID_SERVICE_NAME)) {
        get<Retrofit>(named(AppConstant.COVID_RETROFIT_NAME)).create(
            CovidAPIService::class.java
        )
    }
    single(named(AppConstant.NEWS_SERVICE_NAME)) {
        get<Retrofit>(named(AppConstant.NEWS_RETROFIT_NAME)).create(
            CovidNewsService::class.java
        )
    }
}
