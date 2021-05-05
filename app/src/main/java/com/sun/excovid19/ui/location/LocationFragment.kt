package com.sun.excovid19.ui.location

import com.sun.excovid19.R
import com.sun.excovid19.base.BaseFragment
import com.sun.excovid19.databinding.FragmentLocationBinding
import com.sun.excovid19.ui.home.HomeViewModel
import org.koin.androidx.viewmodel.ext.android.viewModel

class LocationFragment : BaseFragment<FragmentLocationBinding>() {

    override val layoutResources get() = R.layout.fragment_location

    //Fix later in handle task
    override val viewModel by viewModel<HomeViewModel>()

    override fun setupViews() {
    }

    override fun initData() {
    }

    override fun initActions() {
    }
}
