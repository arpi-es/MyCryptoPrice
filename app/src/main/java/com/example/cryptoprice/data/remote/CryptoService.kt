package com.example.cryptoprice.data.remote

import com.example.cryptoprice.data.entities.ApiCrypto
import com.example.cryptoprice.data.entities.Crypto
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path

interface CryptoService {

    @GET("assets")
    suspend fun getAllCryptos() : Response<ApiCrypto>

    @GET("assets/{id}")
    suspend fun getCrypto(@Path("id") id : String) : Response<Crypto>

}