package com.features.bismillahcobakotlin.Codingan.GrowHarvest
import retrofit2.Call
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.create
import retrofit2.http.GET

interface ProductService {
    @GET("produk.php") // Ganti dengan endpoint sesuai API Anda
    fun getProduk(): Call<List<Produk>>
}