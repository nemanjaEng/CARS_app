package com.eng.cars_application


import android.content.Context
import android.util.Log
import android.widget.TextView
import java.io.BufferedReader
import java.io.InputStreamReader


class BussinessLogic {

    fun parseCSV(context: Context) {


        var line: String?
        val openCSV = InputStreamReader(context.assets.open("modelExcelNew.csv"))
        val readLineInCSV = BufferedReader(openCSV)

        readLineInCSV.readLine()

        while (readLineInCSV.readLine().also {
                line = it
            } != null) {

            val row: List<String> = line!!.split(";")
            if (row[0].isNotEmpty()) {

                DataGlobal.cars.add(
                    Car(
                        row,
                        0

                    )
                )
            }

        }
        Log.d("CSV", DataGlobal.cars.count().toString())

    }

    fun parseFirstRowCSV(context: Context) {


        val openCSV = InputStreamReader(context.assets.open("modelExcelNew.csv"))
        val readLineInCSV = BufferedReader(openCSV)

        val row: List<String> = readLineInCSV.readLine()!!.split(";")
        DataGlobal.headings.add(Car(row, 0))


    }

    fun createLogoDataSource() {
        DataGlobal.logos.add(Logo("Audi", R.drawable.audi))
        DataGlobal.logos.add(Logo("Mercedes-Benz", R.drawable.mercedes_benz))
        DataGlobal.logos.add(Logo("Alfa Romeo", R.drawable.alfa_romeo))
        DataGlobal.logos.add(Logo("Citroen", R.drawable.citroen))
        DataGlobal.logos.add(Logo("Dacia", R.drawable.dacia))
        DataGlobal.logos.add(Logo("Fiat", R.drawable.fiat))
        DataGlobal.logos.add(Logo("Honda", R.drawable.honda))
        DataGlobal.logos.add(Logo("Hyundai", R.drawable.hyundai))
        DataGlobal.logos.add(Logo("Infiniti", R.drawable.infiniti))
        DataGlobal.logos.add(Logo("Isuzu", R.drawable.isuzu))
        DataGlobal.logos.add(Logo("Jeep", R.drawable.jeep))
        DataGlobal.logos.add(Logo("Lada", R.drawable.lada))
        DataGlobal.logos.add(Logo("Mini", R.drawable.mini))
        DataGlobal.logos.add(Logo("Ford", R.drawable.ford))
        DataGlobal.logos.add(Logo("Mitsubishi", R.drawable.mitsubishi))
        DataGlobal.logos.add(Logo("Subaru", R.drawable.subaru))
        DataGlobal.logos.add(Logo("Nissan", R.drawable.nissan))
        DataGlobal.logos.add(Logo("Opel", R.drawable.opel))
        DataGlobal.logos.add(Logo("Peugeot", R.drawable.peugeot))
        DataGlobal.logos.add(Logo("Volkswagen", R.drawable.volkswagen))
        DataGlobal.logos.add(Logo("Volvo", R.drawable.volvo))
        DataGlobal.logos.add(Logo("Renault", R.drawable.renault))
        DataGlobal.logos.add(Logo("Seat", R.drawable.seat))
        DataGlobal.logos.add(Logo("Suzuki", R.drawable.suzuki))
        DataGlobal.logos.add(Logo("Skoda", R.drawable.skoda))
        DataGlobal.logos.add(Logo("Mazda", R.drawable.mazda))

    }

    fun createModelImageDataSource() {
        DataGlobal.imagesOfModels.add(
            ModelImage(
                "A1 sportback S line(2018)30 TFSI (116 hp)",
                R.drawable.a1_sportback_2018

            )
        )
        DataGlobal.imagesOfModels.add(
            ModelImage(
                "A1 sportback advanced (2018)30 TFSI (116 hp) S tronic",
                R.drawable.a1_sportback_s_line_2018

            )
        )
        DataGlobal.imagesOfModels.add(
            ModelImage(
                "A-klasaA 180d",
                R.drawable.a_180d
            )
        )

        DataGlobal.imagesOfModels.add(
            ModelImage(
                "A-klasaA 220 4M",
                R.drawable.a200
            )
        )
    }

    fun searchedCars(text: String) {
        var textForSearch = text
        // var textForSearch = etTextForSearch.text.toString().lowercase()
        for (car in DataGlobal.cars) {
            var match = car.elements[0].lowercase() + " " + car.elements[1].lowercase()
            if (match.contains(textForSearch)) {

                DataGlobal.searchedCars.add(car)

            }
        }
    }

    fun addCarsAndImages(): ArrayList<Car> {
        var list: ArrayList<Car> = arrayListOf()
        for (c in DataGlobal.cars) {
            if (c.elements[0] == DataGlobal.carModel) {
                list.add(c)
            }
        }
        //Log.d("LISTA", newListofCarModel.toString())

        for (car in list) {

            for (img in DataGlobal.imagesOfModels) {
                var modelMotor = car.elements[1] + car.elements[2]
                if (modelMotor == img.name)
                    car.image = img.imageModel

            }
        }
        return list
    }

    fun carDetailsAll(marka: String?, model: String?, motor: String?): ArrayList<Car> {
        var listCarDetails: ArrayList<Car> = arrayListOf()
        for (c in DataGlobal.cars) {
            if (c.elements[0] == marka && c.elements[1] == model && c.elements[2] == motor) {
                listCarDetails.add(c)
            }
        }
        return listCarDetails
    }

    fun headingsFourToTen(): List<String> {
        val headings = DataGlobal.headings[0].elements.slice(3..9)
        return headings
    }

    fun detailsFourToTen(list: ArrayList<Car>): ArrayList<String> {
        val list = list[0].elements.slice(3..9)
        return list as ArrayList<String>
    }

    fun printHeadingsFourToTen(headings: List<String>, tv: TextView) {

        for (h in headings) {
            tv.append(h)
            tv.append("\n")
            tv.append("\n")

        }
    }

    fun printDetailsFourToTen(list: ArrayList<String>, tv: TextView) {
        for (l in list) {

            tv.append(l)
            tv.append("\n")
            tv.append("\n")

        }
    }

    fun headingsTenToEnd(): ArrayList<String> {
        val list =
            DataGlobal.headings[0].elements.slice(10..DataGlobal.headings[0].elements.count() - 1)
        return list as ArrayList<String>
    }

    fun detailsTenToEnd(lista: ArrayList<Car>): ArrayList<String> {
        var list = lista[0].elements.slice(10..lista[0].elements.count() - 1)
        return list as ArrayList<String>
    }

    fun printHeadingsToEnd(headings: List<String>, tv: TextView) {

        for (l in headings) {

            tv.append(l)
            tv.append("\n")
            tv.append("\n")

        }
    }

    fun printDetailsToEnd(details: List<String>, tv: TextView) {
        for (h in details) {
            tv.append(h)
            tv.append("\n")
            tv.append("\n")

        }
    }

}