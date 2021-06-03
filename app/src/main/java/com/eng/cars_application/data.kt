package com.eng.cars_application

import android.media.Image

object DataGlobal{

    val user = "user"
    val pass = "pass"

    var usernameLogin: String = ""
    var passwordLogin: String  = ""

    var headings : ArrayList<Car> = arrayListOf()
    var cars: ArrayList<Car> = arrayListOf()
    var logos: ArrayList<Logo> = arrayListOf()
    var imagesOfModels: ArrayList<ModelImage> = arrayListOf()
    var searchedCars : ArrayList<Car> = arrayListOf()

    var image = ""
    var logo  = 0
    var carModel = ""
    var clickCounter = 0
    val bl = BussinessLogic()


}