package com.example.cryptoprice.data.entities

import androidx.databinding.Bindable
import androidx.room.Entity
import androidx.room.PrimaryKey



@Entity(tableName = "tblCrypto")
data class Crypto(
    @PrimaryKey
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
