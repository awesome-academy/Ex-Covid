package com.sun.excovid19.data.repository

import com.sun.excovid19.data.model.RSSItem
import io.reactivex.rxjava3.core.Observable

interface NewsRepository {
    fun getNewsItems(): Observable<List<RSSItem>>
}
