package com.sun.excovid19.di

import com.sun.excovid19.data.repository.*
import com.sun.excovid19.data.source.NewsDataSource
import com.sun.excovid19.data.source.WeekDataSource
import com.sun.excovid19.data.source.WorldDataSource
import com.sun.excovid19.data.source.remote.NewsRemoteDataSource
import com.sun.excovid19.data.source.remote.WeekRemoteDataSource
import com.sun.excovid19.data.source.remote.WorldRemoteDataSource
import com.sun.excovid19.utils.AppConstant
import org.koin.core.qualifier.named
import org.koin.dsl.module

val repositoryModule = module {
    single<WorldDataSource> { WorldRemoteDataSource(get(named(AppConstant.COVID_SERVICE_NAME))) }
    single<WorldRepository> { WorldRepositoryImpl(get()) }
    single<WeekDataSource> { WeekRemoteDataSource(get(named(AppConstant.COVID_SERVICE_NAME))) }
    single<WeekRepository> { WeekRepositoryImpl(get()) }
    single<NewsDataSource> { NewsRemoteDataSource(get(named(AppConstant.NEWS_SERVICE_NAME))) }
    single<NewsRepository> { NewsRepositoryIml(get()) }
}
