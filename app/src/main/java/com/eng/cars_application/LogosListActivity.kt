package com.eng.cars_application

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.recyclerview.widget.GridLayoutManager
import kotlinx.android.synthetic.main.activity_car_brand.*
import kotlinx.android.synthetic.main.activity_logos_list.*

class LogosListActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_logos_list)

        btnSearch.setOnClickListener {
            var txtForSearch = etTextForSearch.text.toString().lowercase()
            DataGlobal.bl.searchedCars(txtForSearch)
            //println(DataGlobal.searchedCars.count().toString())
            ++DataGlobal.clickCounter
            startActivity(Intent(this, CarBrandActivity::class.java))

        }

        val kreiraniAdapter = MyAdapter(DataGlobal.logos)
        recyclerViewLogo.adapter = kreiraniAdapter
        recyclerViewLogo.setLayoutManager(GridLayoutManager(this, 2))
    }

//    override fun onResume() {
//        super.onResume()
//        DataGlobal.searchedCars = arrayListOf()
//        DataGlobal.clickCounter = 0
//    }
}