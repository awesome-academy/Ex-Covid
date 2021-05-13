package com.sun.excovid19.data.source.remote.utils

import com.sun.excovid19.data.model.Food
import io.reactivex.rxjava3.core.Observable
import retrofit2.http.GET
import retrofit2.http.Query

interface FoodAPIService {
    @GET("/recipes/findByNutrients?")
    fun getFoods(
        @Query("minVitaminA") minVitaminA: String,
        @Query("minVitaminC") minVitaminC: String,
        @Query("minProtein") minProtein: String,
        @Query("number") number: String,
        @Query("apiKey") apiKey: String
    ): Observable<List<Food>>
}
