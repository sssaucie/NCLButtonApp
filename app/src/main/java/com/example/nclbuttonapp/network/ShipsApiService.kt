package com.example.nclbuttonapp.network

import com.example.nclbuttonapp.model.entity.ShipEntity
import com.jakewharton.retrofit2.adapter.kotlin.coroutines.CoroutineCallAdapterFactory
import com.squareup.moshi.Moshi
import com.squareup.moshi.kotlin.reflect.KotlinJsonAdapterFactory
import kotlinx.coroutines.Deferred
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import retrofit2.http.GET

private const val baseUrl = "https://www.ncl.com/cms-service/cruise-ships/"
private const val skyUrl = baseUrl + "SKY"
private const val blissUrl = baseUrl + "BLISS"
private const val escapeUrl = baseUrl + "ESCAPE"

private val moshi = Moshi.Builder()
    .add(KotlinJsonAdapterFactory())
    .build()

private val retrofit = Retrofit.Builder()
    .addConverterFactory(MoshiConverterFactory.create(moshi))
    .addCallAdapterFactory(CoroutineCallAdapterFactory())
    .baseUrl(baseUrl)
    .build()

interface ShipsApiService {
    @GET("SKY")
    fun getSky(): Deferred<ShipEntity>
    @GET("BLISS")
    fun getBliss(): Deferred<ShipEntity>
    @GET("ESCAPE")
    fun getEscape(): Deferred<ShipEntity>

    // TODO: Retrofit must have a better way, but cannot find it right now
//    @GET("{ship}")
//    suspend fun ship(@Path("ship") ship: String): Deferred<ShipEntity>
}

object ShipsApi {
    val retrofitService: ShipsApiService by lazy {
        retrofit.create(ShipsApiService::class.java)
    }
}