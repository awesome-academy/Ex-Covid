package com.sun.excovid19.ui.location

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.os.bundleOf
import androidx.databinding.DataBindingUtil
import androidx.navigation.fragment.navArgs
import com.google.android.material.bottomsheet.BottomSheetDialogFragment
import com.sun.excovid19.R
import com.sun.excovid19.base.BaseFragment
import com.sun.excovid19.databinding.BottomSheetWeekBinding
import com.sun.excovid19.databinding.FragmentLocationBinding
import com.sun.excovid19.ui.home.HomeViewModel
import com.sun.excovid19.utils.showToast
import kotlinx.android.synthetic.main.bottom_sheet_week.*
import org.koin.androidx.viewmodel.ext.android.viewModel

class LocationBottomSheetFragment : BottomSheetDialogFragment() {

    private val args: LocationBottomSheetFragmentArgs by navArgs()
    private var binding: BottomSheetWeekBinding? = null

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? = DataBindingUtil
        .inflate<BottomSheetWeekBinding>(inflater, R.layout.bottom_sheet_week, container, false)
        .apply { binding = this }
        .root

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding?.apply {
            lifecycleOwner = this@LocationBottomSheetFragment
            day = args.day
        }
    }

}
