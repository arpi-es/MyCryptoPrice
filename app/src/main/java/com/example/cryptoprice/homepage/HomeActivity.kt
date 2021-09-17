package com.example.cryptoprice.homepage

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.cryptoprice.R
import com.example.cryptoprice.data.model.Crypto
import com.example.cryptoprice.homepage.adapter.HomeAdapter
import java.util.*

class HomeActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        setupUI()
        setupViewModel()
        setupObserver()
    }


    private fun setupUI() {

        val recyclerview = findViewById<RecyclerView>(R.id.recylerHome)
        recyclerview.layoutManager = LinearLayoutManager(this)
        val data = ArrayList<Crypto>()

        for (i in 1..20) {
            data.add(Crypto( i.toString(), "test", "symbol", "122"))
        }

        val adapter = HomeAdapter(data)
        recyclerview.adapter = adapter

    }

    private fun setupViewModel() {
    }

    private fun setupObserver() {
    }


}