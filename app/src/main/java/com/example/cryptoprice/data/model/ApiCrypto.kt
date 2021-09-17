package com.example.cryptoprice.data.model

data class ApiCrypto (
    val cryptos: List<Crypto>,
    val timestamp: Long
)

data class Crypto(
    val id: String,
    val name: String,
    val symbol: String,
    val priceUsd: String,
    val changePercent24Hr: String ?=null,
    val explorer: String?=null,
    val marketCapUsd: String?=null,
    val maxSupply: String ?=null,
    val rank: String ?=null,
    val supply: String ?=null,
    val volumeUsd24Hr: String ?=null,
    val vwap24Hr: String  ?=null
)