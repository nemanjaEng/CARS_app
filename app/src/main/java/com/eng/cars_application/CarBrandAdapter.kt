package com.eng.cars_application

import android.content.Intent
import android.util.Log
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.car_brand_cell.view.*

var rowIndexCarBrend: Int? = null

class CarBrandAdapter(val listOfCars: ArrayList<Car>, val logo: Int?) :
    RecyclerView.Adapter<CustomViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CustomViewHolder {

        val layoutInflater = LayoutInflater.from(parent.context)
        val cellForRow = layoutInflater.inflate(R.layout.car_brand_cell, parent, false)
        return CustomViewHolder(cellForRow)
    }

    override fun onBindViewHolder(holder: CustomViewHolder, position: Int) {

//        if (listOfCars[position].image == 0) {
//            holder.view.ivLogoCarBrand.setImageResource(logo!!)
//        } else {
            holder.view.ivLogoCarBrand.setImageResource(listOfCars[position].image)
//        }
        holder.view.tvModelCarBrand.text = listOfCars[position].elements[1]
        holder.view.tvPriceCarBrand.text = listOfCars[position].elements[4]


        holder.view.cardViewCarBrand.setOnClickListener { v ->
            rowIndexCarBrend = position
            val intent = Intent(v.context, DetailsActivity::class.java)
            intent.putExtra("marka", listOfCars[position].elements[0])
            intent.putExtra("model", listOfCars[position].elements[1])
            intent.putExtra("motor", listOfCars[position].elements[2])


            v.context.startActivity(intent)


        }

    }

    override fun getItemCount(): Int {

        return listOfCars.count()
    }
}