package com.sun.excovid19.data.source.remote

import com.sun.excovid19.data.model.Week
import com.sun.excovid19.data.source.WeekDataSource
import com.sun.excovid19.data.source.remote.utils.CovidAPIService
import io.reactivex.rxjava3.core.Observable

class WeekRemoteDataSource(
    private val apiService: CovidAPIService
) : WeekDataSource {

    override fun getDataByWeek(countryName: String): Observable<Week> =
        apiService.getWeekData(countryName)
}
