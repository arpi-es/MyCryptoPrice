package com.example.cryptoprice.data.entities

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "tblCrypto")
data class Crypto(
    @PrimaryKey
    val id: String,
    val name: String,
    val symbol: String,
    val priceUsd: String
)
