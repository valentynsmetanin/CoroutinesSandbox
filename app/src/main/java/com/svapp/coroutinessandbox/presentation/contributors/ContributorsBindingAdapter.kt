package com.svapp.coroutinessandbox.presentation.contributors

import androidx.databinding.BindingAdapter
import androidx.recyclerview.widget.RecyclerView
import com.svapp.coroutinessandbox.data.model.Contributor

/**
 * Created by Valentyn on 13.01.2019.
 */
object ContributorsBindingAdapter {

    @JvmStatic
    @BindingAdapter(value = ["contributors"])
    fun setContributors(recyclerView: RecyclerView, contributors: List<Contributor>?) {
        (recyclerView.adapter as? ContributorsAdapter)?.items = contributors ?: arrayListOf()
    }

}