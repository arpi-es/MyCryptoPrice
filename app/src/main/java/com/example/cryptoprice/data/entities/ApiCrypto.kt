package com.example.cryptoprice.data.entities

import com.google.gson.annotations.SerializedName




data class ApiCrypto(
        @SerializedName("data")
        val cryptos: List<Crypto>,
        val timestamp: Long
)


