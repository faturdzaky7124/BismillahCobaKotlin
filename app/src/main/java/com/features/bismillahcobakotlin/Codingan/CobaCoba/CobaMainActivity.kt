package com.features.bismillahcobakotlin.Codingan.CobaCoba

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.android.volley.Request
import com.android.volley.Response
import com.android.volley.VolleyError
import com.android.volley.toolbox.JsonArrayRequest
import com.android.volley.toolbox.Volley
import com.features.bismillahcobakotlin.R
import org.json.JSONException

class CobaMainActivity : AppCompatActivity() {

    private val charList = ArrayList<CobaDataModel>()
    private lateinit var recyclerView: RecyclerView
    private lateinit var cobaCustomAdapter: CobaCustomAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_coba_volley_main)

        recyclerView = findViewById(R.id.recyclerView)
        recyclerView.layoutManager = LinearLayoutManager(this)
        cobaCustomAdapter = CobaCustomAdapter(this, charList)
        recyclerView.adapter = cobaCustomAdapter

        val apiUrl = "https://growharvest.my.id/API/produk.php"

        // Menggunakan Volley untuk mengambil data JSON
        val requestQueue = Volley.newRequestQueue(this)

        val jsonArrayRequest = JsonArrayRequest(
            Request.Method.GET, apiUrl, null,
            Response.Listener { response ->
                // Mengambil data produk dari JSON response
                try {
                    for (i in 0 until response.length()) {
                        val charJson = response.getJSONObject(i)
                        val character = CobaDataModel(
                            charJson.getString("name"),
                            charJson.getString("gender"),
                            charJson.getString("image")
                        )
                        charList.add(character)
                    }
                    // Memberitahu adapter bahwa dataset telah berubah
                    cobaCustomAdapter.notifyDataSetChanged()
                } catch (e: JSONException) {
                    e.printStackTrace()
                }
            },
            Response.ErrorListener { error ->
                // Menangani kesalahan
                error.printStackTrace()
                if (error is VolleyError) {
                    val errorMessage = error.message
                    Log.e("VolleyError", errorMessage ?: "Unknown VolleyError")
                }
            }
        )

        // Menambahkan request ke queue
        requestQueue.add(jsonArrayRequest)
    }
}
