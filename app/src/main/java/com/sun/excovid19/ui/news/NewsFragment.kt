package com.sun.excovid19.ui.news

import androidx.lifecycle.Observer
import androidx.navigation.fragment.findNavController
import com.sun.excovid19.R
import com.sun.excovid19.base.BaseFragment
import com.sun.excovid19.base.UpdateDataAdapter
import com.sun.excovid19.data.model.RSSItem
import com.sun.excovid19.databinding.FragmentNewsBinding
import com.sun.excovid19.ui.adapter.NewsAdapter
import kotlinx.android.synthetic.main.fragment_news.*
import org.koin.androidx.viewmodel.ext.android.viewModel

class NewsFragment : BaseFragment<FragmentNewsBinding>() {
    override val layoutResources get() = R.layout.fragment_news

    override val viewModel by viewModel<NewsViewModel>()

    private val newsAdapter = NewsAdapter(::clickItemNews)

    override fun setupViews() {
    }

    override fun initData() {
        recycleNews.adapter = newsAdapter
        binding?.lifecycleOwner = viewLifecycleOwner
        viewModel.newItems.observe(viewLifecycleOwner, Observer {
            newsAdapter.setData(it)
        })
    }

    override fun initActions() {
    }

    private fun clickItemNews(news: RSSItem) {
        val action = NewsFragmentDirections.actionNewsFragmentToFragmentNewsContent(news)
        findNavController().navigate(action)
    }
}
