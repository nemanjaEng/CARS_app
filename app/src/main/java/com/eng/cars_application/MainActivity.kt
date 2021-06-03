package com.eng.cars_application


import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_main.*
import java.io.BufferedReader
import java.io.InputStreamReader
import java.io.Serializable


var logovanje = false

data class Car(
    val elements: List<String>,
    var image: Int
) : Serializable

data class Logo(
    val name: String,
    val imageLogo: Int
) : Serializable


data class ModelImage(
    val name: String,
    val imageModel: Int
) : Serializable

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

//        if (logovanje && DataGlobal.usernameLogin == DataGlobal.user && DataGlobal.passwordLogin == DataGlobal.pass) {
//            Log.d("LOGIN", "Korisnik je ulogovan")
//        } else {
//            Log.d("LOGIN", "Korisnik nije ulogovan")
//            startActivity(Intent(this, LoginActivity::class.java))
//            finish()
//        }

        DataGlobal.bl.parseCSV(this)
        DataGlobal.bl.parseFirstRowCSV(this)
        DataGlobal.bl.createLogoDataSource()
        DataGlobal.bl.createModelImageDataSource()


        btnSeeAllProducts.setOnClickListener {
            startActivity(Intent(this, LogosListActivity::class.java))
        }

    }

}