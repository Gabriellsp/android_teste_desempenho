package com.example.androidteste.view

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.androidteste.R
import com.example.androidteste.models.MarvelCharacter

class MarvelAdapter(private val marvelCharacters: ArrayList<MarvelCharacter>): RecyclerView.Adapter<MarvelAdapter.ViewHolder>() {
    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val marvelImageView = itemView.findViewById<ImageView>(R.id.marvel_image)
        val marvelIdView = itemView.findViewById<TextView>(R.id.marvel_id)
        val marvelNameView = itemView.findViewById<TextView>(R.id.marvel_name)
        val marvelDescriptionView = itemView.findViewById<TextView>(R.id.marvel_description)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.card_marvel_character, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val character = marvelCharacters[position]
        val imageUrl = character.thumbnail!!.path+"."+character.thumbnail!!.extension;
        val id = "Id: "+character.id.toString();
        val name = "Name: "+character.name;
        val description = "Description: "+character.description;
        Glide.with(holder.itemView.context).load(imageUrl).into(holder.marvelImageView);
        holder.marvelIdView.text = id
        holder.marvelNameView.text = name
        holder.marvelDescriptionView.text = description
    }

    override fun getItemCount(): Int {
        return marvelCharacters.size
    }
}