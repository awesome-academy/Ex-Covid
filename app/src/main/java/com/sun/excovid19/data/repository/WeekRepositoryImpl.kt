package com.sun.excovid19.data.repository

import com.sun.excovid19.data.model.Week
import com.sun.excovid19.data.source.WeekDataSource
import io.reactivex.rxjava3.core.Observable

class WeekRepositoryImpl(
    private val remote: WeekDataSource
) : WeekRepository {

    override fun getWeekData(countryName: String): Observable<Week> =
        remote.getDataByWeek(countryName)
}
