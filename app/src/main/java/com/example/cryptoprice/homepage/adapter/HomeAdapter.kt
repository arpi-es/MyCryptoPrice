package com.example.cryptoprice.homepage.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.cryptoprice.R
import com.example.cryptoprice.data.model.Crypto

class HomeAdapter(private val mList: List<Crypto>) : RecyclerView.Adapter<HomeAdapter.HomeAdapterViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): HomeAdapterViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_home, parent, false)

        return HomeAdapterViewHolder(view)
    }

    override fun onBindViewHolder(holder: HomeAdapterViewHolder, position: Int) {
        val ItemsViewModel = mList[position]
        holder.textView.text = ItemsViewModel.name

    }

    override fun getItemCount(): Int {
       return mList.size

    }

    class HomeAdapterViewHolder(v : View) : RecyclerView.ViewHolder(v) {
        val textView: TextView = itemView.findViewById(R.id.txtName)
    }
}