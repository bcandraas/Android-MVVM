package io.bintang.todo.util

import android.widget.ImageView
import androidx.databinding.BindingAdapter
import com.bumptech.glide.Glide
import com.bumptech.glide.load.resource.drawable.DrawableTransitionOptions
import com.bumptech.glide.request.RequestOptions

@BindingAdapter("loadImage")
fun loadImage(view: ImageView, imageUrl: String?) {
    if (imageUrl.isNullOrEmpty()) return

    val url = imageUrl

    Glide.with(view.context)
        .load(url)
        .transition(DrawableTransitionOptions.withCrossFade())
        .thumbnail(0.2f)
        .apply(RequestOptions().override(700))
        .into(view)
}