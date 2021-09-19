package com.example.cryptoprice.data.local

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Update
import com.example.cryptoprice.data.entities.Crypto

@Dao
interface CryptoDatabaseDao {

    @Insert
    suspend fun insert(crypto: Crypto)

    @Update
    suspend fun update(crypto: Crypto)

    @Query("DELETE FROM tblCrypto")
    suspend fun clear()

    @Query("SELECT * FROM tblCrypto ORDER BY id DESC")
    fun getAll(): LiveData<List<Crypto>>

    @Query("SELECT * from tblCrypto WHERE id = :id")
    suspend fun get(id: String): Crypto?

    @Query("SELECT * from tblCrypto WHERE id = :id")
    fun getCryptoWithId(id: String): LiveData<Crypto>

}