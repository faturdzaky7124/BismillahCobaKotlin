//package com.features.bismillahcobakotlin.Codingan.ChatGPT
//import android.content.Context
//import android.view.LayoutInflater
//import android.view.View
//import android.view.ViewGroup
//import android.widget.BaseAdapter
//import android.widget.ImageView
//import android.widget.TextView
//import com.bumptech.glide.Glide
//import com.features.bismillahcobakotlin.R
//
//class CustomAdapter(private val context: Context, private val dataModels: ArrayList<DataModel>) : BaseAdapter() {
//
//    override fun getCount(): Int {
//        return dataModels.size
//    }
//
//    override fun getItem(position: Int): Any {
//        return dataModels[position]
//    }
//
//    override fun getItemId(position: Int): Long {
//        return position.toLong()
//    }
//
//    override fun getView(position: Int, convertView: View?, parent: ViewGroup?): View {
//        var convertView = convertView
//        if (convertView == null) {
//            val inflater = context.getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater
//            convertView = inflater.inflate(R.layout.list_item, null)
//        }
//
//        // Mengambil data untuk posisi tertentu.
//        val dataModel = dataModels[position]
//
//        // Mendapatkan referensi ke elemen UI.
//        val titleTextView: TextView = convertView!!.findViewById(R.id.titleTextView)
//        val imageView: ImageView = convertView.findViewById(R.id.imageView)
//
//        // Menetapkan data ke elemen UI.
//        titleTextView.text = dataModel.name
//
//        // Menggunakan Glide untuk memuat dan menampilkan gambar dari URL.
//        Glide.with(context)
//            .load(dataModel.image)
//            .into(imageView)
//
//        return convertView
//    }
//}