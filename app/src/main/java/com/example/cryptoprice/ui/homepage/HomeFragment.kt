package com.example.cryptoprice.ui.homepage

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.core.os.bundleOf
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import androidx.navigation.NavController
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.cryptoprice.R
import com.example.cryptoprice.data.entities.Crypto
import com.example.cryptoprice.databinding.FragmentHomeBinding
import com.example.cryptoprice.utils.Resource
import com.example.cryptoprice.utils.autoCleared
import dagger.hilt.android.AndroidEntryPoint
import timber.log.Timber

@AndroidEntryPoint
class HomeFragment : Fragment(), HomeItemListener {

    private var binding: FragmentHomeBinding by autoCleared()
    private val viewModel: HomeViewModel by viewModels()
    private lateinit var adapter: HomeAdapter
    private lateinit var navController: NavController

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        navController = findNavController()

        binding = FragmentHomeBinding.inflate(inflater, container, false)
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
            when (it.status) {
                Resource.Status.SUCCESS -> {
                    Timber.d(it.data!!.size.toString())
                    if (!it.data.isNullOrEmpty()) adapter.submitList(ArrayList(it.data))
                }

                Resource.Status.ERROR ->
                    Toast.makeText(requireContext(), it.message, Toast.LENGTH_SHORT).show()

                Resource.Status.LOADING ->
                    Timber.d("LOADING")
//                   binding.progressBar.visibility = View.VISIBLE
            }
        })

    }

    override fun onItemClicked(id: String) {
        Toast.makeText(requireContext(), id, Toast.LENGTH_SHORT).show()
        findNavController().navigate(R.id.action_homeFragment_to_cryptoDetailFragment, bundleOf("id" to id)
        )
    }

}