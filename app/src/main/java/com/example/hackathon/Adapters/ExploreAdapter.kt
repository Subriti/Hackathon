package com.example.MusicPlayer.Adapters

import Explore
import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.hackathon.R


class ExploreAdapter(private val context: Context, private var songDataset: List<Explore>, private val itemClick: (Explore)-> Unit) :
    RecyclerView.Adapter<ExploreAdapter.ItemViewHolder>() {

    class ItemViewHolder(private val view: View, val itemClick: (Explore) -> Unit) : RecyclerView.ViewHolder(view) {
        val imageView: ImageView = view.findViewById(R.id.donor_image)
        val textView: TextView = view.findViewById(R.id.donor_name)
        val textView1: TextView = view.findViewById(R.id.donor_address)
        val textView2: TextView= view.findViewById(R.id.donor_bloodGroup)
        val textView3: TextView= view.findViewById(R.id.type)

        fun bindCategory(songs: Explore, context: Context) {
            itemView.setOnClickListener { itemClick(songs) }
        }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ItemViewHolder {
        // create a new view
        val adapterLayout = LayoutInflater.from(parent.context)
            .inflate(R.layout.explore_item, parent, false)

        return ItemViewHolder(adapterLayout, itemClick)
    }

    override fun onBindViewHolder(holder: ItemViewHolder, position: Int) {
        val item = songDataset[position]
        Glide.with(context).load(item.ImageURL).into(holder.imageView)
        holder.textView.text = context.resources.getString(item.donorName)
        holder.textView1.text = context.resources.getString(item.addresss)
        holder.textView2.text = context.resources.getString(item.bGroup)
        holder.textView3.text = context.resources.getString(item.types1)

        holder.bindCategory(songDataset[position],context)
    }

    override fun getItemCount() = songDataset.size

}

