package com.sun.excovid19.ui.home

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.github.mikephil.charting.data.PieEntry
import com.sun.excovid19.base.RxViewModel
import com.sun.excovid19.data.model.World
import com.sun.excovid19.data.repository.WorldRepository
import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers
import io.reactivex.rxjava3.kotlin.addTo
import io.reactivex.rxjava3.schedulers.Schedulers

class HomeViewModel(
    private val worldRepository: WorldRepository
) : RxViewModel() {
    private val _worldData = MutableLiveData<World>()
    val worldData: LiveData<World> get() = _worldData

    private val _ratioData = MutableLiveData<List<PieEntry>>()
    val ratioData: LiveData<List<PieEntry>> get() = _ratioData

    init {
        getWorldData()
    }

    private fun getWorldData() {
        worldRepository.getWorldData()
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe({
                _worldData.value = it
                getRatioData()
            }, {
                _error.value = it.message.toString()
            })
            .addTo(disposables)
    }

    private fun getRatioData() {
        val ratios = mutableListOf<PieEntry>()
        worldData.value?.let {
            ratios.apply {
                add(PieEntry(it.recoverRatio))
                add(PieEntry(it.deathsRatio))
                _ratioData.value = this
            }
        }
    }
}
