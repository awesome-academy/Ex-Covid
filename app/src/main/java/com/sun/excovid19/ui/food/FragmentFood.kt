package com.sun.excovid19.ui.food

import androidx.lifecycle.Observer
import com.sun.excovid19.R
import com.sun.excovid19.base.BaseFragment
import com.sun.excovid19.data.model.Food
import com.sun.excovid19.databinding.FragmentFoodBinding
import com.sun.excovid19.ui.adapter.FoodAdapter
import com.sun.excovid19.utils.showToast
import kotlinx.android.synthetic.main.fragment_food.*
import org.koin.androidx.viewmodel.ext.android.viewModel

class FragmentFood : BaseFragment<FragmentFoodBinding>() {

    override val viewModel by viewModel<FoodViewModel>()

    override val layoutResources get() = R.layout.fragment_food

    private val foodAdapter = FoodAdapter(::clickItemNews)

    override fun setupViews() {
    }

    override fun initData() {
        binding?.apply {
            recycleFood.adapter = foodAdapter
            lifecycleOwner = viewLifecycleOwner
        }
        viewModel.foodItems.observe(viewLifecycleOwner, Observer { foodAdapter.setData(it) })
    }

    override fun initActions() {
        binding?.buttonFoodSearch?.setOnClickListener {
            val minVitaminA = textSearchVitaminA.text.toString()
            val minVitaminC = textSearchVitaminC.text.toString()
            val minProtein = textSearchProtein.text.toString()
            viewModel.getFoodItem(
                minVitaminA,
                minVitaminC,
                minProtein
            )
        }
    }

    private fun clickItemNews(item: Food) {
        context?.showToast(item.title)
    }
}
