package com.eng.cars_application

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.recyclerview.widget.GridLayoutManager
import kotlinx.android.synthetic.main.activity_car_brand.*
import kotlinx.android.synthetic.main.activity_logos_list.*
import kotlinx.android.synthetic.main.car_brand_cell.*

class CarBrandActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_car_brand)
        ivCardBrand.setImageResource(DataGlobal.logo)

        var newListofCarModel: ArrayList<Car> = DataGlobal.bl.addCarsAndImages()

        //Log.d("LIST", newListofCarModel.toString())

        if (DataGlobal.clickCounter > 0) {
            val carBrandAdapter = CarBrandAdapter(DataGlobal.searchedCars, null)
            recyclerViewCarBrand.adapter = carBrandAdapter
            recyclerViewCarBrand.setLayoutManager(GridLayoutManager(this, 2))
        } else {
            val carBrandAdapter = CarBrandAdapter(newListofCarModel, DataGlobal.logo)
            recyclerViewCarBrand.adapter = carBrandAdapter
            recyclerViewCarBrand.setLayoutManager(GridLayoutManager(this, 2))

        }

    }

    override fun onBackPressed() {
        DataGlobal.searchedCars = arrayListOf()
        DataGlobal.clickCounter = 0
        super.onBackPressed()


    }
}