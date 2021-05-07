package com.sun.excovid19.data.model

import android.os.Parcelable
import com.squareup.moshi.Json
import kotlinx.android.parcel.Parcelize

@Parcelize
data class World(
    @field:Json(name = "total_cases")
    val totalCases: String,
    @field:Json(name = "active_cases")
    val activeCases: String,
    @field:Json(name = "critical")
    val critical: String,
    @field:Json(name = "deaths")
    val deaths: String,
    @field:Json(name = "recovered")
    val recovered: String,
    @field:Json(name = "tested")
    val tested: String,
    @field:Json(name = "death_ratio")
    val deathsRatio: String,
    @field:Json(name = "recovery_ratio")
    val recoverRatio: String,
    var date: String
) : Parcelable
