package com.sun.excovid19.data.repository

import com.sun.excovid19.data.model.Food
import io.reactivex.rxjava3.core.Observable

interface FoodRepository {
    fun getFoods(
        minVitaminA: String,
        minVitaminC: String,
        minProtein: String,
        itemFood: String
    ): Observable<List<Food>>
}
