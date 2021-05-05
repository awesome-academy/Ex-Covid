package com.sun.excovid19.data.repository

import com.sun.excovid19.data.model.Week
import io.reactivex.rxjava3.core.Observable

interface WeekRepository {
    fun getWeekData(countryName: String): Observable<Week>
}
