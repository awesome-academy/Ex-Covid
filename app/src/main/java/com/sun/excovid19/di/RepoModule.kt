package com.sun.excovid19.di

import com.sun.excovid19.data.repository.WeekRepository
import com.sun.excovid19.data.repository.WeekRepositoryImpl
import com.sun.excovid19.data.repository.WorldRepository
import com.sun.excovid19.data.repository.WorldRepositoryImpl
import com.sun.excovid19.data.source.WeekDataSource
import com.sun.excovid19.data.source.WorldDataSource
import com.sun.excovid19.data.source.remote.WeekRemoteDataSource
import com.sun.excovid19.data.source.remote.WorldRemoteDataSource
import org.koin.dsl.module

val repositoryModule = module {
    single<WorldDataSource> { WorldRemoteDataSource(get()) }
    single<WorldRepository> { WorldRepositoryImpl(get()) }
    single<WeekDataSource> { WeekRemoteDataSource(get()) }
    single<WeekRepository> { WeekRepositoryImpl(get()) }
}
