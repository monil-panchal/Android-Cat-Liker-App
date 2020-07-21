package com.example.assignment2.adapter

import android.widget.ImageView
import androidx.databinding.BindingAdapter
import com.bumptech.glide.Glide

/**
 * Created by Monil Panchal, B00838558 on 2020-03-27.
 * Organization: Dalhousie university
 * Email: monil.panchal@dal.ca
 */

/**
 * A [BindingAdapter] implementation.
 * Wiring [Glide] to fetch and display the cat image using the  URL obtained through data binding.
 *It generates runtime binding class and the view will call the setter method.
 */

@BindingAdapter("app:imageUrl")
fun setImageUrl(imageView: ImageView, url: String) {
    Glide.with(imageView.context).load(url).into(imageView);
}