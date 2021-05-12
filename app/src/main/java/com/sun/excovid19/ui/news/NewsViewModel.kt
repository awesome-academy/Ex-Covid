package com.sun.excovid19.ui.news

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.sun.excovid19.base.RxViewModel
import com.sun.excovid19.data.model.RSSItem
import com.sun.excovid19.data.repository.NewsRepository
import com.sun.excovid19.utils.AppConstant
import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers
import io.reactivex.rxjava3.kotlin.addTo
import io.reactivex.rxjava3.schedulers.Schedulers

class NewsViewModel(
    private val repository: NewsRepository
) : RxViewModel() {
    private val _newItems = MutableLiveData<List<RSSItem>>()
    val newItems: LiveData<List<RSSItem>> get() = _newItems

    init {
        getNewsItem()
    }

    private fun getNewsItem() {
        repository.getNewsItems()
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .map {
                it.map { item ->
                    item.copy(description = getLinkImage(item.description))
                }
            }
            .subscribe({
                _newItems.value = it
            }, {
                _error.value = it.message.toString()
            })
            .addTo(disposables)
    }

    private fun getLinkImage(link: String): String {
        val str = link.split(AppConstant.SPLIT_STRING)
        return str[2].substring(AppConstant.DEFAULT_START, str[2].length - AppConstant.DEFAULT_END)
    }
}
