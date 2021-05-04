package com.sun.excovid19.di

import com.sun.excovid19.utils.AppConstant
import okhttp3.OkHttpClient
import org.koin.dsl.module
import retrofit2.Retrofit
import retrofit2.adapter.rxjava3.RxJava3CallAdapterFactory
import retrofit2.converter.moshi.MoshiConverterFactory

val networkModule = module {
    fun initHttpClient(): OkHttpClient {
        val builder = OkHttpClient.Builder()
        builder.addInterceptor { chain ->
            val original = chain.request()
            val url = original.url().newBuilder().build()
            val request = original.newBuilder().url(url).build()
            chain.proceed(request)
        }
        return builder.build()
    }

    fun initRetrofit(client: OkHttpClient): Retrofit {
        return Retrofit.Builder()
            .baseUrl(AppConstant.BASE_COVID_URL)
            .addConverterFactory(MoshiConverterFactory.create())
            .addCallAdapterFactory(RxJava3CallAdapterFactory.create())
            .client(client)
            .build()
    }

    single { initHttpClient() }
    single { initRetrofit(get()) }
}
