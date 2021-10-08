package com.example.cryptoprice.ui.homepage

import androidx.hilt.lifecycle.ViewModelInject
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.cryptoprice.data.entities.Crypto
import com.example.cryptoprice.data.repository.CryptoRepository


class HomeViewModel @ViewModelInject constructor(private val repository: CryptoRepository) :
    ViewModel() {

    val cryptos = repository.getCryptos()


    private val _navigateToDetail = MutableLiveData<Boolean?>()

    val navigateToDetail: LiveData<Boolean?>
        get() = _navigateToDetail

    fun doneNavigating() {
        _navigateToDetail.value = null
    }

    fun onItemClick(item: Crypto) {
        _navigateToDetail.value = true

    }

}