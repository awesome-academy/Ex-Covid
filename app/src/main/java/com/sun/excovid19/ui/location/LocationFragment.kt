package com.sun.excovid19.ui.location

import android.content.Intent
import android.net.Uri
import androidx.navigation.fragment.findNavController
import com.github.mikephil.charting.components.XAxis
import com.github.mikephil.charting.components.YAxis
import com.github.mikephil.charting.data.Entry
import com.github.mikephil.charting.formatter.IndexAxisValueFormatter
import com.github.mikephil.charting.highlight.Highlight
import com.github.mikephil.charting.listener.OnChartValueSelectedListener
import com.sun.excovid19.R
import com.sun.excovid19.base.BaseFragment
import com.sun.excovid19.databinding.FragmentLocationBinding
import com.sun.excovid19.utils.AppConstant
import kotlinx.android.synthetic.main.fragment_location.*
import org.koin.androidx.viewmodel.ext.android.viewModel
import androidx.lifecycle.Observer

class LocationFragment : BaseFragment<FragmentLocationBinding>() {

    override val layoutResources get() = R.layout.fragment_location

    override val viewModel by viewModel<LocationViewModel>()

    override fun setupViews() {
        setUpBarChart()
    }

    override fun initData() {
        val xAxis = chartWeek.xAxis
        binding?.apply {
            lifecycleOwner = viewLifecycleOwner
            locationVM = viewModel
        }
        viewModel.getWeekData(AppConstant.DEFAULT_COUNTRY)
        viewModel.chartData.observe(viewLifecycleOwner, Observer {
            chartWeek.apply {
                data = it
                invalidate()
            }
        })
        viewModel.date.observe(viewLifecycleOwner, Observer {
            xAxis.valueFormatter = IndexAxisValueFormatter(it)
        })
    }

    override fun initActions() {
        chartWeek.setOnChartValueSelectedListener(object : OnChartValueSelectedListener {
            override fun onNothingSelected() {
            }

            override fun onValueSelected(e: Entry, h: Highlight?) {
                val action = viewModel.weekData.value?.get(e.x.toInt() + 1)?.let {
                    LocationFragmentDirections.actionLocationFragmentToBottomFragment(it)
                }
                action?.let {
                    findNavController().navigate(action)
                }
            }
        })
        buttonContract.setOnClickListener { dialPhoneNumber() }
        imageSearch.setOnClickListener {
            val countryName = textSearch.text.toString()
            viewModel.getWeekData(countryName)
        }
    }

    private fun dialPhoneNumber() {
        val intent = Intent(Intent.ACTION_DIAL)
        intent.data = Uri.parse("tel:${AppConstant.SUPPORT_PHONE_NUMBER}")
        startActivity(intent)
    }

    private fun setUpBarChart() {
        val xAxis = chartWeek.xAxis
        chartWeek.apply {
            setPinchZoom(false)
            setDrawBarShadow(false)
            description.isEnabled = false
            animate()
            axisRight.isEnabled = false
            xAxis.axisMinimum = AppConstant.AXIS_MINIMUM_CHART
            xAxis.axisMaximum = AppConstant.AXIS_MAXIMUM_CHART
            legend.isEnabled = false
        }

        val leftAxis: YAxis = chartWeek.axisLeft
        leftAxis.apply {
            setDrawGridLines(false)
            spaceTop = AppConstant.TOP_MARGIN_CHART
            axisMinimum = AppConstant.MINIMUM_CHART
        }

        xAxis.apply {
            granularity = AppConstant.AXIS_MINIMUM_CHART
            position = XAxis.XAxisPosition.BOTTOM
            setCenterAxisLabels(true)
            granularity = AppConstant.AXIS_MINIMUM_CHART
            isGranularityEnabled = true
        }
    }

}
