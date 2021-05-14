package com.sun.excovid19.data.source.remote

import com.sun.excovid19.BuildConfig
import com.sun.excovid19.data.model.Food
import com.sun.excovid19.data.source.FoodDataSource
import com.sun.excovid19.data.source.remote.utils.FoodAPIService
import io.reactivex.rxjava3.core.Observable

class FoodRemoteDataSource(
    private val apiService: FoodAPIService
) : FoodDataSource {
    override fun getFoodItems(
        minVitaminA: String,
        minVitaminC: String,
        minProtein: String,
        itemFood: String
    ): Observable<List<Food>> = apiService.getFoods(
        minVitaminA,
        minVitaminC,
        minProtein,
        itemFood,
        BuildConfig.API_KEY
    )
}
