package com.sun.excovid19.data.source.remote

import com.sun.excovid19.data.model.RSSResponse
import com.sun.excovid19.data.source.NewsDataSource
import com.sun.excovid19.data.source.remote.utils.CovidNewsService
import io.reactivex.rxjava3.core.Observable

class NewsRemoteDataSource(
    private val apiService: CovidNewsService
) : NewsDataSource {
    override fun getNewsItems(): Observable<RSSResponse> = apiService.getNewsItem()
}
