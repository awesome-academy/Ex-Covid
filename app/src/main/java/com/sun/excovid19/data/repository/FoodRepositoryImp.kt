package com.sun.excovid19.data.repository

import com.sun.excovid19.data.model.Food
import com.sun.excovid19.data.source.FoodDataSource
import com.sun.excovid19.utils.AppConstant
import io.reactivex.rxjava3.core.Observable

class FoodRepositoryImp(
    private val remote: FoodDataSource
) : FoodRepository {
    override fun getFoods(
        minVitaminA: String,
        minVitaminC: String,
        minProtein: String
    ): Observable<List<Food>> = remote.getFoodItems(
        minVitaminA,
        minVitaminC,
        minProtein,
        AppConstant.FOOD_DEFAULT_NUMBER
    )
}
