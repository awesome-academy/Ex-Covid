package com.sun.excovid19.ui.home

import android.graphics.Color
import com.github.mikephil.charting.data.PieData
import com.github.mikephil.charting.data.PieDataSet
import com.github.mikephil.charting.data.PieEntry
import com.github.mikephil.charting.formatter.PercentFormatter
import com.sun.excovid19.R
import com.sun.excovid19.base.BaseFragment
import com.sun.excovid19.databinding.FragmentHomeBinding
import kotlinx.android.synthetic.main.fragment_home.*
import org.koin.androidx.viewmodel.ext.android.viewModel
import com.github.mikephil.charting.animation.Easing

class HomeFragment() : BaseFragment<FragmentHomeBinding>() {

    override val layoutResources get() = R.layout.fragment_home

    override val viewModel by viewModel<HomeViewModel>()

    override fun setupViews() {
        setupPieChart()
    }

    override fun initData() {
        binding?.apply {
            lifecycleOwner = viewLifecycleOwner
            homeVM = viewModel
        }
        viewModel.ratioData.observe(viewLifecycleOwner, androidx.lifecycle.Observer {
            updatePieChart(it)
        })
    }

    override fun initActions() {
    }

    private fun updatePieChart(entries: List<PieEntry>?) {
        val colors = mutableListOf<Int>()
        context?.resources?.let {
            colors.apply {
                add(it.getColor(R.color.color_carnation))
                add(it.getColor(R.color.color_koromiko))
            }
        }
        val dataSet = PieDataSet(entries, DATA_LABEL)
        dataSet.colors = colors
        val data = PieData(dataSet)
        data.apply {
            setDrawValues(true)
            setValueFormatter(PercentFormatter(chartRecover))
            setValueTextSize(TEXT_SIZE)
            setValueTextColor(Color.WHITE)
            chartRecover.data = this
        }
        chartRecover.invalidate()
    }

    private fun setupPieChart() {
        chartRecover.apply {
            isDrawHoleEnabled = true
            holeRadius = HOLE_RADIUS
            setTransparentCircleAlpha(TRANSPARENT_ALPHA)
            description.isEnabled = false
            animateY(TIME_ANIM, Easing.EaseInOutQuad)
        }
        val legend = chartRecover.legend
        legend.isEnabled = false
    }

    companion object {
        const val HOLE_RADIUS = 2f
        const val TRANSPARENT_ALPHA = 0
        const val TIME_ANIM = 2000
        const val DATA_LABEL = ""
        const val TEXT_SIZE = 16f
    }
}
