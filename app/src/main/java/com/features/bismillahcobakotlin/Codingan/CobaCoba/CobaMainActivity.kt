package com.features.bismillahcobakotlin.Codingan.CobaCoba

import android.os.Bundle
import android.widget.ListView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.android.volley.Request
import com.android.volley.RequestQueue
import com.android.volley.Response
import com.android.volley.toolbox.JsonArrayRequest
import com.android.volley.toolbox.JsonObjectRequest
import com.android.volley.toolbox.Volley
import com.features.bismillahcobakotlin.R
import org.json.JSONArray
import org.json.JSONException
import org.json.JSONObject
import java.util.ArrayList

class CobaMainActivity : AppCompatActivity() {
    private lateinit var textViewName: TextView
    private lateinit var textViewYear: TextView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_coba_main)  // Sesuaikan dengan nama layout yang Anda miliki

        fetchData()
    }

    private fun fetchData() {
        val url = "https://reqres.in/api/user"

        val requestQueue: RequestQueue = Volley.newRequestQueue(this)

        val jsonObjectRequest = JsonObjectRequest(
            Request.Method.GET, url, null,
            Response.Listener { response ->
                // Handle the response
                val name = response.getJSONObject("data").getString("first_name")
                val year = response.getJSONObject("data").getString("year")

                // Tampilkan data ke dalam layout
                textViewName.text = "Nama: $name"
                textViewYear.text = "Tahun: $year"
            },
            Response.ErrorListener { error ->
                // Handle errors
                textViewName.text = "Error: ${error.message}"
            }
        )

        // Add the request to the RequestQueue
        requestQueue.add(jsonObjectRequest)
    }
}
