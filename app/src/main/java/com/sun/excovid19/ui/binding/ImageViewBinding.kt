package com.sun.excovid19.ui.binding

import android.widget.ImageView
import androidx.databinding.BindingAdapter
import com.sun.excovid19.utils.loadImage

@BindingAdapter("app:image")
fun loadUrlImageCircle(imageView: ImageView, urlImage: String) {
    imageView.loadImage(urlImage)
}
