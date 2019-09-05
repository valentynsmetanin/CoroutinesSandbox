package com.svapp.coroutinessandbox.presentation.contributors

import androidx.recyclerview.widget.DiffUtil
import com.svapp.coroutinessandbox.data.model.Contributor

/**
 * Created by Valentyn on 19.01.2019.
 */
class ContributorsItemCallback : DiffUtil.ItemCallback<Contributor>() {

    override fun areContentsTheSame(oldItem: Contributor, newItem: Contributor) =
        oldItem.avatarUrl == newItem.avatarUrl && oldItem.name == newItem.name

    override fun areItemsTheSame(oldItem: Contributor, newItem: Contributor) =
        oldItem.id == newItem.id

}