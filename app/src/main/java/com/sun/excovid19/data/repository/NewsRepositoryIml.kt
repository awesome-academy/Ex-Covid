package com.sun.excovid19.data.repository

import com.sun.excovid19.data.model.RSSItem
import com.sun.excovid19.data.source.NewsDataSource
import io.reactivex.rxjava3.core.Observable

class NewsRepositoryIml(
    private val remote: NewsDataSource
) : NewsRepository {

    override fun getNewsItems(): Observable<List<RSSItem>> =
        remote.getNewsItems().map { it.channel?.item }
}
