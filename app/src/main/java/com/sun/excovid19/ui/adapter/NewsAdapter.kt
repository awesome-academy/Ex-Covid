package com.sun.excovid19.ui.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import com.sun.excovid19.R
import com.sun.excovid19.base.BaseAdapter
import com.sun.excovid19.base.BaseViewHolder
import com.sun.excovid19.data.model.RSSItem
import com.sun.excovid19.databinding.ItemNewsBinding

class NewsAdapter(
    private val onClickItem: (RSSItem) -> Unit
) : BaseAdapter<RSSItem, NewsAdapter.NewsViewHolder>(RSSItem.diffUtil) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) =
        NewsViewHolder(
            DataBindingUtil.inflate(
                LayoutInflater.from(parent.context), R.layout.item_news, parent, false
            ),
            onClickItem
        )

    class NewsViewHolder(
        private val itemBannerBinding: ItemNewsBinding,
        onClickItem: (RSSItem) -> Unit
    ) : BaseViewHolder<RSSItem>(itemBannerBinding, onClickItem) {

        override fun bindData(item: RSSItem) {
            super.bindData(item)
            itemBannerBinding.news = item
        }
    }
}
