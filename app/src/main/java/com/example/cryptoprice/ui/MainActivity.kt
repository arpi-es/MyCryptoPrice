package com.example.cryptoprice.ui

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.NavController
import androidx.navigation.fragment.NavHostFragment
import com.example.cryptoprice.R
import com.example.cryptoprice.databinding.ActivityMainBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val binding:  ActivityMainBinding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val navHostFragment : NavHostFragment = supportFragmentManager.findFragmentById(R.id.nav_host_fragment) as NavHostFragment
        val navController : NavController = navHostFragment.navController




//        setupUI()
//        setupViewModel()
//        setupObserver()
    }


//    private fun setupUI() {
//
//        val recyclerview = findViewById<RecyclerView>(R.id.recylerHome)
//        recyclerview.layoutManager = LinearLayoutManager(this)
//        val data = ArrayList<Crypto>()
//
//        for (i in 1..20) {
//            data.add(Crypto( i.toString(), "test", "symbol", "122"))
//        }
//
//        val adapter = HomeAdapter(data)
//        recyclerview.adapter = adapter
//
//    }
//
//    private fun setupViewModel() {
//    }
//
//    private fun setupObserver() {
//    }


}