package com.features.bismillahcobakotlin.Codingan.GrowHarvest
import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.features.bismillahcobakotlin.R

class ProductAdapter(private val context: Context) : RecyclerView.Adapter<ProductAdapter.ViewHolder>() {

    private var produks: List<Produk> = ArrayList()

    fun setProducts(produks: List<Produk>) {
        this.produks = produks
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(context).inflate(R.layout.data_barang_adapter, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val produk = produks[position]

        holder.namaProduk.text = produk.nama_produk
        holder.hargaProduk.text = produk.harga_produk

        // Menggunakan Glide untuk menampilkan gambar dari URL
        Glide.with(context)
            .load(produk.gambar_produk)
            .placeholder(R.drawable.ic_placeholder)
            .into(holder.gambarProduk)
    }

    override fun getItemCount(): Int {
        return produks.size
    }

    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val namaProduk: TextView = itemView.findViewById(R.id.namaProduk)
        val hargaProduk: TextView = itemView.findViewById(R.id.hargaProduk)
        val gambarProduk: ImageView = itemView.findViewById(R.id.gambarProduk)
    }
}