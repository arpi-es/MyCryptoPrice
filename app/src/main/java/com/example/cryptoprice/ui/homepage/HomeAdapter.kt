package com.example.cryptoprice.ui.homepage

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.cryptoprice.data.entities.Crypto
import com.example.cryptoprice.databinding.ItemHomeBinding


class HomeAdapter(private val listener:  CryptoItemListener ) : ListAdapter<Crypto,  HomeAdapter.HomeAdapterViewHolder>(DiffCallback()) {


    interface CryptoItemListener {
        fun onClickedCrypto(id: String)
    }

//    private val items = ArrayList<Crypto>()

//    fun setItems(items: ArrayList<Crypto>) {
//        this.items.clear()
//        this.items.addAll(items)
//        notifyDataSetChanged()
//    }



    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): HomeAdapterViewHolder {
//        val view = LayoutInflater.from(parent.context)
//            .inflate(R.layout.item_home, parent, false)
//
//        return HomeAdapterViewHolder(view , listener)
//        return HomeAdapterViewHolder.from(parent)

        return HomeAdapterViewHolder.from(parent)

    }

    override fun onBindViewHolder(holder: HomeAdapterViewHolder, position: Int) {
//        val ItemsViewModel = items[position]
//        holder.textView.text = ItemsViewModel.name

        val item = getItem(position)
        holder.bind( listener , item )

    }


    class HomeAdapterViewHolder private constructor(val binding: ItemHomeBinding) : RecyclerView.ViewHolder(binding.root) {
        fun bind( clickListener:CryptoItemListener , item : Crypto){
            binding.item = item
        }


        companion object{
            fun from(parent: ViewGroup) : HomeAdapterViewHolder{
                val layoutInflater = LayoutInflater.from(parent.context)
                val binding = ItemHomeBinding.inflate(layoutInflater, parent, false)
                return HomeAdapterViewHolder(binding)
            }

        }
    }



    private class DiffCallback: DiffUtil.ItemCallback<Crypto>() {
        override fun areItemsTheSame(oldItem: Crypto, newItem: Crypto): Boolean {
            return oldItem.id == newItem.id
        }

        @SuppressLint("DiffUtilEquals")
        override fun areContentsTheSame(oldItem: Crypto, newItem: Crypto): Boolean {
            return oldItem == newItem
        }
    }






}