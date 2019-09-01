package com.svapp.coroutinessandbox.presentation.base

import android.widget.ImageView
import androidx.databinding.BindingAdapter
import com.bumptech.glide.load.engine.DiskCacheStrategy

/**
 * Created by Valentyn on 13.01.2019.
*/

@BindingAdapter("imageUrl")
fun ImageView.loadImage(url: String?) {
    url?.let {
        GlideApp.with(this.context)
            .load(it)
            .diskCacheStrategy(DiskCacheStrategy.AUTOMATIC)
            .into(this)
    }
}