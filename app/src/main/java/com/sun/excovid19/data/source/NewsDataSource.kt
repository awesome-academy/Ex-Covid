package com.sun.excovid19.data.source

import com.sun.excovid19.data.model.RSSResponse
import io.reactivex.rxjava3.core.Observable

interface NewsDataSource {
    fun getNewsItems(): Observable<RSSResponse>
}
