package com.example.garycheng.myapplication

import android.content.Context
import android.content.Intent
import android.graphics.Color
import android.support.v4.content.ContextCompat.startActivity
import android.support.v7.widget.RecyclerView
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import kotlinx.android.synthetic.main.animal_list_item.view.*

class AnimalAdapter(private val items: ArrayList<String>, private val context: Context)
    : RecyclerView.Adapter<AnimalAdapter.MyViewHolder>() {

    // Gets the number of animals in the list
    override fun getItemCount(): Int {
        return items.size
    }

    // Inflates the item views
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        return MyViewHolder(LayoutInflater.from(context).inflate(R.layout.animal_list_item, parent, false), context, items)
    }

    // Binds each animal in the ArrayList to a view
    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        holder.tvAnimalType.text = items[position]

        if (items[position] == "treasure") {
            holder.tvAnimalType.setTextColor(Color.RED)
        }
    }

    class MyViewHolder (view: View, context: Context, items: ArrayList<String>) : RecyclerView.ViewHolder(view) {
        // Holds the TextView that will add each animal to
        var tvAnimalType: TextView = view.tv_animal_type
        val animalButton: Button = view.animal_button

        init {
            tvAnimalType.setOnClickListener {
                val intent = Intent(context , ThirdActivity::class.java)
                intent.putExtra(ThirdActivity.TYPE, items[adapterPosition])
                intent.putExtra(ThirdActivity.POSITION, adapterPosition)

                startActivity(context, intent, null)
            }

            animalButton.setOnClickListener {
                val intent = Intent(context, AnimalActivity::class.java)
                intent.putExtra(AnimalActivity.TYPE_ONLY, items[adapterPosition])

                startActivity(context, intent, null)
            }
        }
    }
}

