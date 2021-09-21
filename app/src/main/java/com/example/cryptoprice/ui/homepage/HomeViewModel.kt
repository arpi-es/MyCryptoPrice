package com.example.cryptoprice.ui.homepage

import androidx.hilt.lifecycle.ViewModelInject
import androidx.lifecycle.ViewModel
import com.example.cryptoprice.data.repository.CryptoRepository


class HomeViewModel @ViewModelInject constructor(private val repository: CryptoRepository ) : ViewModel() {

        val cryptos = repository.getCryptos()



//        suspend fun getAllTest() : Response<ApiCrypto> {
//           val a : Response<ApiCrypto> = remoteDataSource.getTest()
//            Log.i("MYTAG2", a.message() )
//
//
//            return  a
//
//        }

}