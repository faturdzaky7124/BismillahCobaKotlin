package com.features.bismillahcobakotlin.Codingan.GrowHarvest

import com.google.gson.annotations.SerializedName

data class Produk(
    @SerializedName("nama_produk")
    val nama_produk: String?,
    @SerializedName("harga_produk")
    val harga_produk: String,
    @SerializedName("gambar_produk")
    val gambar_produk: String?
)
