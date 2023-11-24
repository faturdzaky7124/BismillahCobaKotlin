package com.features.bismillahcobakotlin.Codingan.GrowHarvest
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.features.bismillahcobakotlin.R
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class GrowHarvestMainActivity : AppCompatActivity() {
    private lateinit var recyclerView: RecyclerView
    private lateinit var productAdapter: ProductAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_data_barang)

        recyclerView = findViewById(R.id.recyclerView)
        productAdapter = ProductAdapter(this)
        recyclerView.adapter = productAdapter
        recyclerView.layoutManager = LinearLayoutManager(this)

        // Ganti BASE_URL dengan URL sesuai API Anda
        val retrofit = Retrofit.Builder()
            .baseUrl("https://growharvest.my.id/API/produk/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()

        val productService = retrofit.create(ProductService::class.java)

        val call: Call<List<Produk>> = productService.getProduk()

        call.enqueue(object : Callback<List<Produk>> {
            override fun onResponse(call: Call<List<Produk>>, response: Response<List<Produk>>) {
                if (response.isSuccessful) {
                    val produks: List<Produk>? = response.body()
                    produks?.let {
                        productAdapter.setProducts(it)
                    }
                }
            }

            override fun onFailure(call: Call<List<Produk>>, t: Throwable) {
                // Handle failure
            }
        })
    }
}