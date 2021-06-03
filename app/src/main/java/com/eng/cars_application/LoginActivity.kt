package com.eng.cars_application

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_login.*

class LoginActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        btnLogin.setOnClickListener {
            DataGlobal.usernameLogin = etUser.text.toString()
            DataGlobal.passwordLogin =  etPass.text.toString()
            startActivity(Intent(this, MainActivity::class.java))

            logovanje = true
            finish()
        }
    }
}