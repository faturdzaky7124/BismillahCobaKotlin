package com.features.bismillahcobakotlin.Codingan.ChatGPT

import android.os.Bundle
import android.widget.ListView
import androidx.appcompat.app.AppCompatActivity
import com.android.volley.Request
import com.android.volley.RequestQueue
import com.android.volley.Response
import com.android.volley.toolbox.JsonArrayRequest
import com.android.volley.toolbox.Volley
import com.features.bismillahcobakotlin.R
import org.json.JSONArray
import org.json.JSONException
import org.json.JSONObject
import java.util.ArrayList

class MainActivity : AppCompatActivity() {
    private val API_URL = "https://rickandmortyapi.com/api/character/"
    private lateinit var dataModels: ArrayList<DataModel>
    private lateinit var adapter: CustomAdapter
    private lateinit var listView: ListView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        listView = findViewById(R.id.listView)
        dataModels = ArrayList()

        // Membuat CustomAdapter dan menginisialisasi adapter.
        adapter = CustomAdapter(this, dataModels)
        listView.adapter = adapter

        // Menginisialisasi RequestQueue.
        val queue: RequestQueue = Volley.newRequestQueue(this)

        // Membuat request JSON untuk mendapatkan data dari API.
        val jsonArrayRequest = JsonArrayRequest(
            Request.Method.GET,
            API_URL,
            null,
            Response.Listener<JSONArray> { response ->
                // Parsing response JSON.
                try {
                    parseData(response)
                } catch (e: JSONException) {
                    e.printStackTrace()
                }
            },
            Response.ErrorListener { error ->
                // Handle error.
                error.printStackTrace()
            })

        // Menambahkan request ke RequestQueue.
        queue.add(jsonArrayRequest)
    }

    private fun parseData(response: JSONArray) {
        try {
            // Iterasi melalui setiap objek JSON dalam respons.
            for (i in 0 until response.length()) {
                val jsonObject = response.getJSONObject(i)

                // Mendapatkan data yang diperlukan.
                val name = jsonObject.getString("name")
                val image = jsonObject.getString("image")

                // Membuat objek DataModel dan menambahkannya ke ArrayList.
                val dataModel = DataModel(name, image)
                dataModels.add(dataModel)
            }

            // Memberitahu adapter bahwa data telah berubah.
            adapter.notifyDataSetChanged()

        } catch (e: JSONException) {
            e.printStackTrace()
        }
    }
}
