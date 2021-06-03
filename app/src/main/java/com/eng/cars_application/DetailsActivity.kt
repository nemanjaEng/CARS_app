package com.eng.cars_application

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import kotlinx.android.synthetic.main.activity_details.*

class DetailsActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_details)

        val markDetails = intent.getStringExtra("marka")
        val modelDetails = intent.getStringExtra("model")
        val motorDetails = intent.getStringExtra("motor")

        tvMarkDetails.text = markDetails
        tvModelDetails.text = modelDetails
        tvMotorDetails.text = motorDetails

        var listCarDetails: ArrayList<Car> =
            DataGlobal.bl.carDetailsAll(markDetails, modelDetails, motorDetails)


        val headingsFourToTen = DataGlobal.bl.headingsFourToTen()
        val detailsFourToTen = DataGlobal.bl.detailsFourToTen(listCarDetails)
//        println(headingsFourToTen.toString())
//        println(detailsFourToTen.toString())

        DataGlobal.bl.printHeadingsFourToTen(headingsFourToTen, tv4_10HeadingDetails)
        DataGlobal.bl.printDetailsFourToTen(detailsFourToTen, tv4_10Details)


        val headingsInvisible = DataGlobal.bl.headingsTenToEnd()
        var listInvisible = DataGlobal.bl.detailsTenToEnd(listCarDetails)
//        println(headingsInvisible.toString())
//        println(listInvisible.toString())
        DataGlobal.bl.printHeadingsToEnd(headingsInvisible, tvNotVisibleHeadingDetails)
        DataGlobal.bl.printDetailsToEnd(listInvisible, tvNotVisibleDetails)


        var otvoren = false

        tvPrikazi.setOnClickListener {
            if (!otvoren) {
                loHiden.visibility = View.VISIBLE


            } else {
                loHiden.visibility = View.GONE


            }
            otvoren = !otvoren
        }


    }
}