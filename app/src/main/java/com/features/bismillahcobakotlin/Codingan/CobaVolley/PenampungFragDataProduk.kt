package com.features.bismillahcobakotlin.Codingan.CobaVolley
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.features.bismillahcobakotlin.R
import android.widget.FrameLayout;

class PenampungFragDataProduk : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_penampung_frag_data_barang)

        if (savedInstanceState == null) {
            supportFragmentManager.beginTransaction()
                .replace(R.id.container, DataProduk())
                .commit()
        }
    }
}