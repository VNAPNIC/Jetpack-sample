
package com.google.samples.apps.sunflower.adapters

import android.databinding.BindingAdapter
import android.support.design.widget.FloatingActionButton
import android.text.SpannableStringBuilder
import android.widget.ImageView
import android.widget.TextView
import androidx.core.text.bold
import androidx.core.text.italic
import com.bumptech.glide.Glide
import com.bumptech.glide.load.resource.drawable.DrawableTransitionOptions
import com.google.samples.apps.sunflower.R

@BindingAdapter("imageFromUrl")
fun imageFromUrl(view: ImageView, imageUrl: String?) {
    if (!imageUrl.isNullOrEmpty()) {
        Glide.with(view.context)
                .load(imageUrl)
                .transition(DrawableTransitionOptions.withCrossFade())
                .into(view)
    }
}

@BindingAdapter("goneIf")
fun goneIf(view: FloatingActionButton, isGone: Boolean?) {
    if (isGone == null || isGone) view.hide() else view.show()
}

@BindingAdapter("wateringText")
fun wateringText(textView: TextView, wateringInterval: Int) {
    val resources = textView.context.resources
    val quantityString = resources.getQuantityString(R.plurals.watering_needs_suffix,
        wateringInterval, wateringInterval)

    textView.text = SpannableStringBuilder()
        .bold { append(resources.getString(R.string.watering_needs_prefix)) }
        .append(" ")
        .italic { append(quantityString) }
}