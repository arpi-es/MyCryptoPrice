package com.example.cryptoprice.data.repository

import com.example.cryptoprice.data.local.CryptoDatabaseDao
import com.example.cryptoprice.data.remote.CryptoRemoteDataSource
import com.example.cryptoprice.utils.performGetOperation
import javax.inject.Inject

class CryptoRepository @Inject constructor(
    private val remoteDataSource : CryptoRemoteDataSource,
    private val localDataSource : CryptoDatabaseDao
) {

    fun getCryptos() = performGetOperation(
       databaseQuery =  {localDataSource.getAll()},
        networkCall = {remoteDataSource.getAll()},
        saveCallResult = {localDataSource.insertAll(it.cryptos) }
    )



}

