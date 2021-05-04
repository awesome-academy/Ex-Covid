package com.sun.excovid19.data.model

import com.squareup.moshi.Json

data class WorldSummary(
    @field:Json(name = "summary")
    val worldData: World
)
