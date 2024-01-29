package com.example.rickandmorty

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import coil.load
import coil.transform.CircleCropTransformation
import com.example.rickandmorty.network.Character

class MainAdapter(val characterList: List<Character>):RecyclerView.Adapter<MainAdapter.MainViewHolder>() {

    inner class MainViewHolder(private val itemView: View):RecyclerView.ViewHolder(itemView){
        fun bindData(character: Character){
            val name = itemView.findViewById<TextView>(R.id.name)
            val species = itemView.findViewById<TextView>(R.id.specie)
            val status = itemView.findViewById<TextView>(R.id.status)
            val image  = itemView.findViewById<ImageView>(R.id.image)

            name.text =character.name
            species.text=character.species
            status.text=character.status

            image.load(character.image){
                transformations(CircleCropTransformation())
            }

        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MainViewHolder {
       return MainViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.vr_item,parent,false))
    }

    override fun getItemCount(): Int {
       return characterList.size
    }

    override fun onBindViewHolder(holder: MainViewHolder, position: Int) {
        holder.bindData(characterList[position])
    }


}