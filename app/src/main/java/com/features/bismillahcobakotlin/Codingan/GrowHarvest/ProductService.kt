package com.features.bismillahcobakotlin.Codingan.GrowHarvest
import retrofit2.Call
import retrofit2.http.GET

interface ProductService {
    @GET("produk") // Ganti dengan endpoint sesuai API Anda
    fun getProduk(): Call<List<Produk>>
}