package com.sun.excovid19

import android.app.Application
import com.sun.excovid19.di.apiModule
import com.sun.excovid19.di.networkModule
import com.sun.excovid19.di.repositoryModule
import com.sun.excovid19.di.viewModelModule
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin

class MyApplication : Application() {
    override fun onCreate() {
        super.onCreate()
        startKoin {
            androidContext(this@MyApplication)
            modules(
                listOf(
                    networkModule,
                    apiModule,
                    repositoryModule,
                    viewModelModule
                )
            )

        }
    }
}
