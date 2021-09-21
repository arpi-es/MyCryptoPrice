package com.example.cryptoprice.data.remote

import javax.inject.Inject

class CryptoRemoteDataSource @Inject constructor
    (private val cryptoService: CryptoService) : BaseDataSource() {


    suspend fun getTest() = cryptoService.getAllCryptos()
    suspend fun getAll() = getResult { cryptoService.getAllCryptos() }
    suspend fun getCryptoWithId(id:String) = getResult { cryptoService.getCrypto(id) }
}