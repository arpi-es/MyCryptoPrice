package com.example.cryptoprice.data.local

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.example.cryptoprice.data.entities.Crypto


@Database(entities = [Crypto::class], version = 1, exportSchema = false)
@TypeConverters(Converters::class)
abstract class CryptoDatabase : RoomDatabase() {

    abstract fun  cryptoDatabaseDao(): CryptoDatabaseDao

//    companion object{
//
//        @Volatile
//        private var instance : CryptoDatabase? = null
//
//
//        fun getDatabase(context: Context): CryptoDatabase =
//            instance ?: synchronized(this) { instance ?: buildDatabase(context).also { instance = it } }
//
//        private fun buildDatabase(appContext: Context) =
//            Room.databaseBuilder(appContext, CryptoDatabase::class.java, "characters")
//                .fallbackToDestructiveMigration()
//                .build()
//    }

}