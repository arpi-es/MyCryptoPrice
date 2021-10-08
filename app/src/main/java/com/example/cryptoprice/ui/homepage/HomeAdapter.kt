package com.example.cryptoprice.ui.homepage

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.cryptoprice.data.entities.Crypto
import com.example.cryptoprice.databinding.ItemHomeBinding

class HomeAdapter(private val listener: HomeItemListener) :
    ListAdapter<Crypto, HomeAdapter.HomeAdapterViewHolder>(DiffCallback()) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): HomeAdapterViewHolder {
        return HomeAdapterViewHolder.from(parent)
    }

    override fun onBindViewHolder(holder: HomeAdapterViewHolder, position: Int) {
        val item = getItem(position)
        holder.bind(listener, item)
    }

    class HomeAdapterViewHolder private constructor(val binding: ItemHomeBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(clickListener: HomeItemListener, item: Crypto) {
            binding.item = item
            binding.clickListener = clickListener
        }

        companion object {
            fun from(parent: ViewGroup): HomeAdapterViewHolder {
                val layoutInflater = LayoutInflater.from(parent.context)
                val binding = ItemHomeBinding.inflate(layoutInflater, parent, false)
                return HomeAdapterViewHolder(binding)
            }
        }
    }

    private class DiffCallback : DiffUtil.ItemCallback<Crypto>() {
        override fun areItemsTheSame(oldItem: Crypto, newItem: Crypto): Boolean {
            return oldItem.id == newItem.id
        }

        @SuppressLint("DiffUtilEquals")
        override fun areContentsTheSame(oldItem: Crypto, newItem: Crypto): Boolean {
            return oldItem == newItem
        }
    }

}