package com.sun.excovid19.data.repository

import com.sun.excovid19.data.model.World
import io.reactivex.rxjava3.core.Observable

interface WorldRepository {
    fun getWorldData(): Observable<World>
}
