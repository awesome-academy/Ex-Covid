package com.sun.excovid19.data.source.remote

import com.sun.excovid19.data.source.WorldDataSource
import com.sun.excovid19.data.source.remote.utils.CovidAPIService

class WorldRemoteDataSource(
    private val apiService: CovidAPIService
) : WorldDataSource {

    override fun getWorldResponse() = apiService.getWorldData()
}
