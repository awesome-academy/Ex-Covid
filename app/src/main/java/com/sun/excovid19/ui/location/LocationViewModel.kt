package com.sun.excovid19.ui.location

import android.graphics.Color
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.github.mikephil.charting.data.BarData
import com.github.mikephil.charting.data.BarDataSet
import com.github.mikephil.charting.data.BarEntry
import com.sun.excovid19.base.RxViewModel
import com.sun.excovid19.data.model.Week
import com.sun.excovid19.data.model.World
import com.sun.excovid19.data.repository.WeekRepository
import com.sun.excovid19.utils.AppConstant
import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers
import io.reactivex.rxjava3.kotlin.addTo
import io.reactivex.rxjava3.schedulers.Schedulers


class LocationViewModel(
    private val repository: WeekRepository
) : RxViewModel() {
    private val _weekData = MutableLiveData<List<World>>()
    val weekData: LiveData<List<World>> get() = _weekData

    private val _countryName = MutableLiveData<String>()
    val countryName: LiveData<String> get() = _countryName

    private val _date = MutableLiveData<List<String>>()
    val date: LiveData<List<String>> get() = _date

    private val _currentData = MutableLiveData<World>()
    val currentData: LiveData<World> get() = _currentData

    private val _chartData = MutableLiveData<BarData>()
    val chartData: LiveData<BarData> get() = _chartData

    fun getWeekData(countryName: String) {
        repository.getWeekData(countryName)
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe({
                _countryName.value = countryName
                setWeekData(it)
                generateBarData()
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

    private fun generateBarData() {
        val entriesTotal = mutableListOf<BarEntry>()
        val entriesDeath = mutableListOf<BarEntry>()
        val entriesRecover = mutableListOf<BarEntry>()
        val dates = mutableListOf<String>()
        _weekData.value?.let {
            for (index in 1 until it.size) {
                entriesTotal.add(
                    BarEntry(
                        AppConstant.MINIMUM_CHART,
                        it[index].totalCases.toFloat()
                    )
                )
                entriesDeath.add(
                    BarEntry(
                        AppConstant.MINIMUM_CHART,
                        it[index].deaths.toFloat()
                    )
                )
                entriesRecover.add(
                    BarEntry(
                        AppConstant.MINIMUM_CHART,
                        it[index].recovered.toFloat()
                    )
                )
                dates.add(it[index].date)
            }
        }

        val totalSet = setBarDataSet(
            entriesTotal,
            Color.rgb(
                AppConstant.DEFAULT_RED_TOTAL,
                AppConstant.DEFAULT_GREEN_TOTAL,
                AppConstant.DEFAULT_BLUE_TOTAL
            ),
            AppConstant.DEFAULT_LABEL
        )
        val deathSet = setBarDataSet(
            entriesDeath,
            Color.rgb(
                AppConstant.DEFAULT_RED_DEATH,
                AppConstant.DEFAULT_GREEN_DEATH,
                AppConstant.DEFAULT_RED_TOTAL
            ),
            AppConstant.DEFAULT_LABEL
        )
        val recoverSet = setBarDataSet(
            entriesRecover,
            Color.RED,
            AppConstant.DEFAULT_LABEL
        )
        val dataSet = BarData(totalSet, deathSet, recoverSet)
        dataSet.barWidth = AppConstant.BAR_WITH
        dataSet.groupBars(
            AppConstant.AXIS_MINIMUM_CHART,
            AppConstant.GROUP_SPACE_CHART,
            AppConstant.MINIMUM_CHART
        )
        _chartData.value = dataSet
        _date.value = dates
    }

    private fun setBarDataSet(
        entriesData: MutableList<BarEntry>,
        color: Int,
        label: String
    ): BarDataSet {
        val setData = BarDataSet(entriesData, label)
        setData.setColors(color)
        return setData
    }
}
