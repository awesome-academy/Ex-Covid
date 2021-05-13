package com.sun.excovid19.data.model

import android.os.Parcelable
import androidx.recyclerview.widget.DiffUtil
import com.squareup.moshi.Json
import kotlinx.android.parcel.Parcelize

@Parcelize
data class Food(
    @field:Json(name = "title")
    val title: String,
    @field:Json(name = "image")
    val image: String,
    @field:Json(name = "calories")
    val calories: String,
    @field:Json(name = "protein")
    val protein: String,
    @field:Json(name = "fat")
    val fat: String,
    @field:Json(name = "vitaminA")
    val vitaminA: String,
    @field:Json(name = "vitaminC")
    val vitaminC: String
) : Parcelable {

    companion object {
        val diffUtil = object : DiffUtil.ItemCallback<Food>() {
            override fun areItemsTheSame(oldItem: Food, newItem: Food) =
                oldItem.title == newItem.title

            override fun areContentsTheSame(oldItem: Food, newItem: Food) = oldItem == newItem
        }
    }
}
