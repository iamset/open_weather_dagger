package com.example.weather.location

import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.weather.R
import com.example.weather.utils.OnTextClickListener

class LocationsAdapter(
    private val dataSet: List<Location>,
    private val listener: OnTextClickListener
    ): RecyclerView.Adapter<LocationsAdapter.ViewHolder>() {

    inner class ViewHolder(view: View) : RecyclerView.ViewHolder(view){
        val cityNameView:TextView

        init {
            cityNameView = view.findViewById(R.id.txt_city_name)

        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.location_item, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val location = dataSet[position]
        holder.cityNameView.text = location.name
        holder.cityNameView.setOnClickListener{
            listener.onTextClick(location)
        }
    }

    override fun getItemCount(): Int {
        return dataSet.size
    }
}