package com.sun.excovid19.utils

import android.widget.ImageView
import com.bumptech.glide.Glide
import com.sun.excovid19.R

fun ImageView.loadImage(image: String) {
    Glide.with(context)
        .load(image)
        .error(R.drawable.logo)
        .placeholder(R.drawable.ic_place_holder)
        .into(this)
}

