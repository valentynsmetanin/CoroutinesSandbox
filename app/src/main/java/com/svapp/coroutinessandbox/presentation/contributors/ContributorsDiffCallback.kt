package com.svapp.coroutinessandbox.presentation.contributors

import androidx.recyclerview.widget.DiffUtil
import com.svapp.coroutinessandbox.data.model.Contributor

/**
 * Created by Valentyn on 19.01.2019.
 */
class ContributorsDiffCallback(
    private val newContributors: List<Contributor>,
    private val oldContributors: List<Contributor>
) : DiffUtil.Callback() {

    override fun getOldListSize() = oldContributors.size

    override fun getNewListSize() = newContributors.size

    override fun areItemsTheSame(oldItemPosition: Int, newItemPosition: Int) =
        oldContributors[oldItemPosition].id == newContributors[newItemPosition].id

    override fun areContentsTheSame(oldItemPosition: Int, newItemPosition: Int): Boolean {
        val old = oldContributors[oldItemPosition]
        val new = newContributors[newItemPosition]

        return old.avatarUrl == new.avatarUrl
                && old.name == new.name
    }

}