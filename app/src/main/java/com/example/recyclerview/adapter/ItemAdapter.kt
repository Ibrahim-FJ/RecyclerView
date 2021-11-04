package com.example.recyclerview.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.recyclerview.R
import com.example.recyclerview.model.Affirmation
import com.google.android.material.card.MaterialCardView
import com.google.android.material.imageview.ShapeableImageView


class ItemAdapter(private val context: Context, private val dataSet:
MutableList<Affirmation>): RecyclerView.Adapter<ItemAdapter.ItemViewHolder>() {


    class ItemViewHolder(view: View): RecyclerView.ViewHolder(view) {
        val textView: TextView = view.findViewById(R.id.text_view)
        val imageView: ShapeableImageView = view.findViewById(R.id.image_view)
        val cardView: MaterialCardView = view.findViewById(R.id.card_view)
        val delete_item: ImageView = view.findViewById(R.id.delete_item)


    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ItemViewHolder {
        return ItemViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.item_list_images, parent, false))
    }


    override fun onBindViewHolder(holder: ItemViewHolder, position: Int) {
        val item = dataSet[position]
        holder.textView.text = context.resources.getString(item.stringResourceId)
        holder.imageView.setImageResource(item.imageId)

        holder.imageView.setOnLongClickListener {
            dataSet.removeAt(position)
            notifyDataSetChanged()
            true
        }


    }

    override fun getItemCount(): Int {
        return dataSet.size
    }

}