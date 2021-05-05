package com.sun.excovid19.data.source

import com.sun.excovid19.data.model.Week
import io.reactivex.rxjava3.core.Observable

interface WeekDataSource {
    fun getDataByWeek(countryName: String): Observable<Week>
}
