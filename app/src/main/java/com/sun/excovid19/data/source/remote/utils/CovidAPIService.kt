package com.sun.excovid19.data.source.remote.utils

import com.sun.excovid19.data.model.WorldResponse
import io.reactivex.rxjava3.core.Observable
import retrofit2.http.GET

interface CovidAPIService {
    @GET("summary/latest")
    fun getWorldData(): Observable<WorldResponse>
}
