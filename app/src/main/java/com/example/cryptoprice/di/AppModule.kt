package com.example.cryptoprice.di

import android.content.Context
import com.example.cryptoprice.data.local.CryptoDatabase
import com.example.cryptoprice.data.local.CryptoDatabaseDao
import com.example.cryptoprice.data.remote.CryptoRemoteDataSource
import com.example.cryptoprice.data.remote.CryptoService
import com.example.cryptoprice.data.repository.CryptoRepository
import com.google.gson.Gson
import com.google.gson.GsonBuilder
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ApplicationComponent
import dagger.hilt.android.qualifiers.ApplicationContext
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(ApplicationComponent::class)
object AppModule {

    @Singleton
    @Provides
    fun provideRetrofit(gson: Gson) : Retrofit = Retrofit.Builder()
        .baseUrl("https://api.coincap.io/v2/")
        .addConverterFactory(GsonConverterFactory.create(gson))
        .build()

    @Provides
    fun provideGson(): Gson = GsonBuilder().create()

    @Provides
    fun provideCryptoService(retrofit: Retrofit): CryptoService = retrofit.create(CryptoService::class.java)

    @Singleton
    @Provides
    fun provideCryptoRemoteDataSource(cryptoService: CryptoService) = CryptoRemoteDataSource(cryptoService)

    @Singleton
    @Provides
    fun provideDatabase(@ApplicationContext appContext: Context) = CryptoDatabase.getDatabase(appContext)

    @Singleton
    @Provides
    fun provideCryptoDatabaseDao(db: CryptoDatabase) = db.cryptoDatabaseDao()

    @Singleton
    @Provides
    fun provideRepository(remoteDataSource: CryptoRemoteDataSource,
                          localDataSource: CryptoDatabaseDao) =
        CryptoRepository(remoteDataSource, localDataSource)
}