package com.sun.excovid19.data.source

import com.sun.excovid19.data.model.Food
import io.reactivex.rxjava3.core.Observable

interface FoodDataSource {
    fun getFoodItems(
        minVitaminA: String,
        minVitaminC: String,
        minProtein: String,
        itemFood: String
    ): Observable<List<Food>>
}
