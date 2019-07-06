package com.svapp.coroutinessandbox.presentation.base

import android.widget.ImageView
import androidx.databinding.BindingAdapter
import com.bumptech.glide.load.engine.DiskCacheStrategy

/**
 * Created by Valentyn on 13.01.2019.
 */
object BaseBindingAdapter {

    @JvmStatic
    @BindingAdapter(value = ["imageUrl"])
    fun loadImage(imageView: ImageView, url: String?) {
        url.let {
            GlideApp.with(imageView.context)
                .load(it)
                .diskCacheStrategy(DiskCacheStrategy.AUTOMATIC)
                .into(imageView)
        }
    }

}