package com.svapp.coroutinessandbox.presentation.contributors

import androidx.recyclerview.widget.DiffUtil
import com.svapp.coroutinessandbox.data.model.Contributor
import java.util.*

/**
 * Created by Valentyn on 19.01.2019.
 */
class ContributorsDiffCallback(private val newTrophies: List<Contributor>,
                               private val oldTrophies: List<Contributor>) : DiffUtil.Callback() {

    override fun getOldListSize(): Int {
        return oldTrophies.size
    }

    override fun getNewListSize(): Int {
        return newTrophies.size
    }

    override fun areItemsTheSame(oldItemPosition: Int, newItemPosition: Int): Boolean {
        return oldTrophies[oldItemPosition].name == newTrophies[newItemPosition].name
    }

    override fun areContentsTheSame(oldItemPosition: Int, newItemPosition: Int): Boolean {
        val old = oldTrophies[oldItemPosition]
        val new = newTrophies[newItemPosition]

        return Objects.equals(old, new)
    }

}