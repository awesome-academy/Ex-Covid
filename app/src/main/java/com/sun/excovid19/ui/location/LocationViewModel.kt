package com.sun.excovid19.ui.location

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.sun.excovid19.base.RxViewModel
import com.sun.excovid19.data.model.Week
import com.sun.excovid19.data.model.World
import com.sun.excovid19.data.repository.WeekRepository
import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers
import io.reactivex.rxjava3.kotlin.addTo
import io.reactivex.rxjava3.schedulers.Schedulers

class LocationViewModel(
    private val repository: WeekRepository
) : RxViewModel() {
    private val _weekData = MutableLiveData<List<World>>()
    val weekData: LiveData<List<World>> get() = _weekData

    private val _currentData = MutableLiveData<World>()
    val currentData: LiveData<World> get() = _currentData

    fun getWeekData(countryName: String) {
        repository.getWeekData(countryName)
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe({
                setWeekData(it)
            }, {
                _error.value = it.message.toString()
            })
            .addTo(disposables)
    }

    private fun setWeekData(data: Week) {
        val date = data.weekData.keys.toList()
        val weekData = data.weekData.values.toMutableList()
        weekData.forEachIndexed() { index, item ->
            item.date = date[index]
        }
        _weekData.value = weekData
        _currentData.value = weekData[0]
    }
}
