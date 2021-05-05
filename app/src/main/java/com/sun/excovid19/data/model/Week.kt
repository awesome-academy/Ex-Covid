package com.sun.excovid19.data.model

import com.squareup.moshi.Json

data class Week(
    @field:Json(name = "data")
    val weekData: Map<String, World>
)
