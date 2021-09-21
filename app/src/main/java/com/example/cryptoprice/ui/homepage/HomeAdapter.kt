package com.example.cryptoprice.ui.homepage

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.cryptoprice.R
import com.example.cryptoprice.data.entities.Crypto

class HomeAdapter(private val listener:  CryptoItemListener ) : RecyclerView.Adapter<HomeAdapter.HomeAdapterViewHolder>() {


    interface CryptoItemListener {
        fun onClickedCrypto(id: String)
    }

    private val items = ArrayList<Crypto>()

    fun setItems(items: ArrayList<Crypto>) {
        this.items.clear()
        this.items.addAll(items)
        notifyDataSetChanged()
    }



    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): HomeAdapterViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_home, parent, false)

        return HomeAdapterViewHolder(view , listener)
    }

    override fun onBindViewHolder(holder: HomeAdapterViewHolder, position: Int) {
        val ItemsViewModel = items[position]
        holder.textView.text = ItemsViewModel.name

    }

    override fun getItemCount(): Int {
       return items.size

    }

    class HomeAdapterViewHolder(v : View, private val listener: HomeAdapter.CryptoItemListener) : RecyclerView.ViewHolder(v) {
        val textView: TextView = itemView.findViewById(R.id.txtName)
    }
}