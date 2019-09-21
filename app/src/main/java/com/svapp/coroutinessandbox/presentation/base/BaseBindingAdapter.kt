package com.svapp.coroutinessandbox.presentation.base

import android.widget.ImageView
import androidx.databinding.BindingAdapter
import coil.api.load

/**
 * Created by Valentyn on 13.01.2019.
 */

@BindingAdapter("imageUrl")
fun ImageView.loadImage(url: String?) = url?.let { load(it) }