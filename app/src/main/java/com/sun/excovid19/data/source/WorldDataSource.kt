package com.sun.excovid19.data.source

import com.sun.excovid19.data.model.WorldResponse
import io.reactivex.rxjava3.core.Observable

interface WorldDataSource {
    fun getWorldResponse(): Observable<WorldResponse>
}
