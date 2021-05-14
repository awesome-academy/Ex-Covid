package com.sun.excovid19.ui.food

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.sun.excovid19.base.RxViewModel
import com.sun.excovid19.data.model.Food
import com.sun.excovid19.data.repository.FoodRepository
import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers
import io.reactivex.rxjava3.kotlin.addTo
import io.reactivex.rxjava3.schedulers.Schedulers

class FoodViewModel(
    private val repository: FoodRepository
) : RxViewModel() {
    private val _foodItems = MutableLiveData<List<Food>>()
    val foodItems: LiveData<List<Food>> get() = _foodItems

    fun getFoodItem(
        minVitaminA: String,
        minVitaminC: String,
        minProtein: String
    ) {
        repository.getFoods(
            minVitaminA,
            minVitaminC,
            minProtein
        )
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe({
                _foodItems.value = it
            }, {
                _error.value = it.message.toString()
            })
            .addTo(disposables)
    }
}
