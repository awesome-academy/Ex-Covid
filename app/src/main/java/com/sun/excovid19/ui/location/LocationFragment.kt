package com.sun.excovid19.ui.location

import com.sun.excovid19.R
import com.sun.excovid19.base.BaseFragment
import com.sun.excovid19.databinding.FragmentLocationBinding
import com.sun.excovid19.utils.AppConstant
import org.koin.androidx.viewmodel.ext.android.viewModel

class LocationFragment : BaseFragment<FragmentLocationBinding>() {

    override val layoutResources get() = R.layout.fragment_location

    override val viewModel by viewModel<LocationViewModel>()

    override fun setupViews() {
    }

    override fun initData() {
        binding?.apply {
            lifecycleOwner = viewLifecycleOwner
            locationVM = viewModel
        }
        viewModel.getWeekData(AppConstant.DEFAULT_COUNTRY)
    }

    override fun initActions() {
    }
}
