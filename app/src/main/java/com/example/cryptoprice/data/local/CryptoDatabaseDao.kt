package com.example.cryptoprice.data.local

import androidx.lifecycle.LiveData
import androidx.room.*
import com.example.cryptoprice.data.entities.Crypto

@Dao
interface CryptoDatabaseDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insert(crypto: Crypto)

    @Update
    suspend fun update(crypto: Crypto)

    @Query("DELETE FROM tblCrypto")
    suspend fun clear()

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertAll(cryptos : List<Crypto> )

    @Query("SELECT * FROM tblCrypto ORDER BY cast(rank AS INT) Asc")
    fun getAll(): LiveData<List<Crypto>>

//    @Query("SELECT * from tblCrypto WHERE id = :id")
//    suspend  fun get(id: String): Crypto?

    @Query("SELECT * from tblCrypto WHERE id = :id")
    fun getCryptoWithId(id: String): LiveData<Crypto>





}