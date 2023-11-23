package com.features.bismillahcobakotlin.Codingan.GrowHarvest
import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.ImageView
import android.widget.TextView
import com.bumptech.glide.Glide
import com.features.bismillahcobakotlin.R

class ProductAdapter(private val context: Context) : BaseAdapter() {

    private var produks: List<Produk> = ArrayList()

    fun setProducts(produks: List<Produk>) {
        this.produks = produks
        notifyDataSetChanged()
    }

    override fun getCount(): Int {
        return produks.size
    }

    override fun getItem(position: Int): Any {
        return produks[position]
    }

    override fun getItemId(position: Int): Long {
        return position.toLong()
    }

    override fun getView(position: Int, convertView: View?, parent: ViewGroup?): View {
        val view: View
        val viewHolder: ViewHolder

        if (convertView == null) {
            view = LayoutInflater.from(context).inflate(R.layout.grid_item_product, parent, false)
            viewHolder = ViewHolder(view)
            view.tag = viewHolder
        } else {
            view = convertView
            viewHolder = view.tag as ViewHolder
        }

        val produk = getItem(position) as Produk

        viewHolder.namaProduk.text = produk.nama_produk
        viewHolder.hargaProduk.text = produk.harga_produk

        // Menggunakan Glide untuk menampilkan gambar dari URL
        Glide.with(context)
            .load(produk.gambar_produk)
            .placeholder(R.drawable.ic_placeholder)
            .into(viewHolder.gambarProduk)

        return view
    }

    private class ViewHolder(view: View) {
        val namaProduk: TextView = view.findViewById(R.id.namaProduk)
        val hargaProduk: TextView = view.findViewById(R.id.hargaProduk)
        val gambarProduk: ImageView = view.findViewById(R.id.gambarProduk)
    }
}