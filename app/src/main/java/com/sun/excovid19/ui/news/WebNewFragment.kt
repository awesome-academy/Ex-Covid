package com.sun.excovid19.ui.news

import android.webkit.WebViewClient
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import com.sun.excovid19.R
import com.sun.excovid19.base.BaseFragment
import com.sun.excovid19.databinding.FragmentNewsContentBinding
import kotlinx.android.synthetic.main.fragment_news_content.*
import org.koin.androidx.viewmodel.ext.android.viewModel

class WebNewFragment : BaseFragment<FragmentNewsContentBinding>() {
    override val layoutResources get() = R.layout.fragment_news_content

    override val viewModel by viewModel<NewsViewModel>()

    private val args: WebNewFragmentArgs by navArgs()

    override fun setupViews() {
    }

    override fun initData() {
        binding?.lifecycleOwner = viewLifecycleOwner
        binding?.webNews?.apply {
            webViewClient = WebViewClient()
            loadUrl(args.news.link)
        }
    }

    override fun initActions() {
        textBack.setOnClickListener {
            val action = WebNewFragmentDirections.actionFragmentNewsContentToNewsFragment()
            findNavController().navigate(action)
        }
    }
}
