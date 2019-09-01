package com.svapp.coroutinessandbox.presentation.contributors

import androidx.databinding.BindingAdapter
import androidx.recyclerview.widget.RecyclerView
import com.svapp.coroutinessandbox.data.model.Contributor

/**
 * Created by Valentyn on 13.01.2019.
 */

@BindingAdapter("contributors")
fun RecyclerView.setContributors(contributors: List<Contributor>?) {
    (this.adapter as? ContributorsAdapter)?.items = contributors ?: emptyList()
}