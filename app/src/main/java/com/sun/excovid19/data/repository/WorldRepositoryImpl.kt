package com.sun.excovid19.data.repository

import com.sun.excovid19.data.model.World
import com.sun.excovid19.data.source.WorldDataSource
import io.reactivex.rxjava3.core.Observable

class WorldRepositoryImpl(
    private val remote: WorldDataSource
) : WorldRepository {

    override fun getWorldData(): Observable<World> =
        remote.getWorldResponse().map { it.worldSummary.worldData }
}
