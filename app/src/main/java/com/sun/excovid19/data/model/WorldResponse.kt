package com.sun.excovid19.data.model

import com.squareup.moshi.Json

data class WorldResponse(
    @field:Json(name = "data")
    val worldSummary: WorldSummary
)
