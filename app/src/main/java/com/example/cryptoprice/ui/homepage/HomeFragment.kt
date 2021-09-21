package com.example.cryptoprice.ui.homepage

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.cryptoprice.databinding.FragmentHomeBinding
import com.example.cryptoprice.utils.Resource
import com.example.cryptoprice.utils.autoCleared
import dagger.hilt.android.AndroidEntryPoint


@AndroidEntryPoint
class HomeFragment : Fragment(), HomeAdapter.CryptoItemListener {

    private var binding : FragmentHomeBinding by autoCleared()
    private val viewModel : HomeViewModel by viewModels()
    private lateinit var adapter: HomeAdapter


    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        binding = FragmentHomeBinding.inflate(inflater, container, false)


//        lifecycleScope.launch {
//            val result =  viewModel.getAllTest()
//            Log.i("MYTAG2", "result" )
//            Log.i("MYTAG2", result.body().toString())
//
//        }


        return binding.root

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setupRecyclerView()
        setupObservers()
    }

    private fun setupRecyclerView() {
        adapter = HomeAdapter(this)
        binding.recyclerHome.layoutManager = LinearLayoutManager(requireContext())
        binding.recyclerHome.adapter = adapter

    }

    private fun setupObservers() {



       viewModel.cryptos.observe(viewLifecycleOwner, Observer {
//
//           Log.i("MYTAG", it.data!!.size.toString())
           when (it.status) {
//
               Resource.Status.SUCCESS -> {
                   Log.i("MYTAG", it.data!!.size.toString())
               }
//
               Resource.Status.ERROR ->  Log.i("MYTAG", "ERROR")
               Resource.Status.LOADING ->  Log.i("MYTAG", "LOADING")
//
//
////               Resource.Status.SUCCESS -> {
//////                   binding.progressBar.visibility = View.GONE
//////                   if (!it.data.isNullOrEmpty()) adapter.setItems(ArrayList(it.data))
////                   it.data?.let { it1 -> Toast.makeText(requireContext(), it1.size, Toast.LENGTH_SHORT).show() }
////
////
////               }
//////               Resource.Status.ERROR ->
//////                   Toast.makeText(requireContext(), it.message, Toast.LENGTH_SHORT).show()
////
//////               Resource.Status.LOADING ->
//////                   binding.progressBar.visibility = View.VISIBLE
           }
       })

    }

    override fun onClickedCrypto(id: String) {
//        Toast.makeText(requireContext(), id , Toast.LENGTH_SHORT).show()
//        findNavController().navigate(
//            R.id.action_homeFragment_to_cryptoDetailFragment,
//            bundleOf("id" to id)
//        )
    }


}