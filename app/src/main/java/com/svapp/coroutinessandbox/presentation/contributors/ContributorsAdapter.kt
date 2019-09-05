package com.svapp.coroutinessandbox.presentation.contributors

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.svapp.coroutinessandbox.R
import com.svapp.coroutinessandbox.data.model.Contributor
import com.svapp.coroutinessandbox.databinding.ItemContributorBinding

/**
 * Created by Valentyn on 13.01.2019.
 */
class ContributorsAdapter(private val listener: ContributorClickListener? = null) :
    ListAdapter<Contributor, ContributorsAdapter.ContributorsViewHolder>(ContributorsItemCallback()) {

    override fun onBindViewHolder(holder: ContributorsViewHolder, position: Int) {
        val contributor = getItem(position)
        holder.bind(contributor)
        holder.itemView.setOnClickListener {
            listener?.onContributorClick(contributor)
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ContributorsViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        val binding = DataBindingUtil.inflate<ItemContributorBinding>(
            layoutInflater, R.layout.item_contributor, parent, false
        )
        return ContributorsViewHolder(binding)
    }

    class ContributorsViewHolder(private val binding: ItemContributorBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(contributor: Contributor?) {
            binding.contributor = contributor
        }
    }

    interface ContributorClickListener {
        fun onContributorClick(contributor: Contributor)
    }

}