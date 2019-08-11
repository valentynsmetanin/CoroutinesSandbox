package com.svapp.coroutinessandbox.presentation.contributors

import androidx.recyclerview.widget.DiffUtil
import com.svapp.coroutinessandbox.data.model.Contributor
import java.util.*

/**
 * Created by Valentyn on 19.01.2019.
 */
class ContributorsDiffCallback(private val newContributors: List<Contributor>,
                               private val oldContributors: List<Contributor>) : DiffUtil.Callback() {

    override fun getOldListSize() = oldContributors.size

    override fun getNewListSize() = newContributors.size

    override fun areItemsTheSame(oldItemPosition: Int, newItemPosition: Int) =
        oldContributors[oldItemPosition].name == newContributors[newItemPosition].name

    override fun areContentsTheSame(oldItemPosition: Int, newItemPosition: Int): Boolean {
        val old = oldContributors[oldItemPosition]
        val new = newContributors[newItemPosition]

        return Objects.equals(old, new)
    }

}