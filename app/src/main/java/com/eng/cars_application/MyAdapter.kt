package com.eng.cars_application

import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.logos_list_cell.view.*

var rowIndex: Int? = null
class MyAdapter(val listOfLogos: ArrayList<Logo>) : RecyclerView.Adapter<CustomViewHolder>(){
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CustomViewHolder {

        val layoutInflater = LayoutInflater.from(parent.context)
        val cellForRow = layoutInflater.inflate(R.layout.logos_list_cell, parent, false)
        return CustomViewHolder(cellForRow)
    }

    override fun onBindViewHolder(holder: CustomViewHolder, position: Int) {

        holder.view.ivLogo.setImageResource(listOfLogos[position].imageLogo)
        holder.view.tvLogoName.text = listOfLogos[position].name

        holder.view.cardViewMark.setOnClickListener {view ->
            rowIndex = position
            val intent = Intent(view.context, CarBrandActivity::class.java)
            DataGlobal.logo = listOfLogos[position].imageLogo
            DataGlobal.carModel = listOfLogos[position].name

            view.context.startActivity(intent)

        }

    }

    override fun getItemCount(): Int {

       return    listOfLogos.count()
    }
}

class CustomViewHolder(val view: View) : RecyclerView.ViewHolder(view) {


}