package com.example.submissionapk


import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.core.content.ContextCompat.startActivity
import androidx.recyclerview.widget.RecyclerView

class ListShoeAdapter(private val listShoe: ArrayList<Shoe>)
    : RecyclerView.Adapter<ListShoeAdapter.ListViewHolder>() {

    var onItemClick : ((Shoe) -> Unit)? = null

    class ListViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val imgPhoto: ImageView = itemView.findViewById(R.id.img_item_photo)
        val tvName: TextView = itemView.findViewById(R.id.tv_item_name)
        val tvDescription: TextView = itemView.findViewById(R.id.tv_item_description)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ListViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_row_shoe, parent, false)
        return ListViewHolder(view)
    }

    override fun onBindViewHolder(holder: ListViewHolder, position: Int) {
        val shoe = listShoe[position]
        holder.imgPhoto.setImageResource(shoe.photo)
        holder.tvName.text = shoe.name
        holder.tvDescription.text = shoe.description

        holder.itemView.setOnClickListener {
            onItemClick?.invoke(shoe)
        }
    }

    override fun getItemCount(): Int {
        return listShoe.size
    }
}