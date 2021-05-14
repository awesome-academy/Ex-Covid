package com.sun.excovid19.ui.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import com.sun.excovid19.R
import com.sun.excovid19.base.BaseAdapter
import com.sun.excovid19.base.BaseViewHolder
import com.sun.excovid19.data.model.Food
import com.sun.excovid19.databinding.ItemFoodBinding

class FoodAdapter(
    private val onClickItem: (Food) -> Unit
) : BaseAdapter<Food, FoodAdapter.FoodViewHolder>(Food.diffUtil) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) =
        FoodViewHolder(
            DataBindingUtil.inflate(
                LayoutInflater.from(parent.context), R.layout.item_food, parent, false
            ),
            onClickItem
        )

    class FoodViewHolder(
        private val itemFoodBinding: ItemFoodBinding,
        onClickItem: (Food) -> Unit
    ) : BaseViewHolder<Food>(itemFoodBinding, onClickItem) {

        override fun bindData(item: Food) {
            super.bindData(item)
            itemFoodBinding.food = item
        }
    }
}
