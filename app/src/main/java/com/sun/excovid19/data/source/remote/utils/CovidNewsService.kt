package com.sun.excovid19.data.source.remote.utils

import com.sun.excovid19.data.model.RSSResponse
import io.reactivex.rxjava3.core.Observable
import retrofit2.http.GET

interface CovidNewsService {
    @GET("rss/suc-khoe.rss")
    fun getNewsItem(): Observable<RSSResponse>
}
