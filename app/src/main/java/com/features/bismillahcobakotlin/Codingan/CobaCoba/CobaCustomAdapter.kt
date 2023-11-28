package com.features.bismillahcobakotlin.Codingan.CobaCoba

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.features.bismillahcobakotlin.R

class CobaCustomAdapter(private val context: Context, private val charList: List<CobaDataModel>) :
    RecyclerView.Adapter<CobaCustomAdapter.ViewHolder>() {

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val charName: TextView = itemView.findViewById(R.id.productName)
        val charGender: TextView = itemView.findViewById(R.id.productPrice)
        val charImage: ImageView = itemView.findViewById(R.id.productImage)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view =
            LayoutInflater.from(context).inflate(R.layout.item_product_volley, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val character = charList[position]

        holder.charName.text = character.name
        holder.charGender.text = "Gender: ${character.gender}"
        Glide.with(context)
            .load(character.image)
            .into(holder.charImage)
    }

    override fun getItemCount(): Int {
        return charList.size
    }
}
