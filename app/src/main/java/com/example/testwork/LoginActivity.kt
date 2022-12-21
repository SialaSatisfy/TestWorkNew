package com.example.testwork

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.EditText

class LoginActivity : AppCompatActivity() {

    private lateinit var prefManager: PrefManager
    private lateinit var etUsername: EditText
    private lateinit var etPassword: EditText
    private lateinit var username: String
    private lateinit var password: String

// DATA Validation
    private var validUsername = "admin"
    private var validPassword = "1234"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        init()
        chechLogin()
    }

    private fun init(){
        prefManager = PrefManager(this)
        etUsername = findViewById(R.id.ET_Username)
        etPassword = findViewById(R.id.ET_Password)
    }

    private fun chechLogin(){
        if (prefManager.isLogin()!!){
            val intent = Intent(this,MainActivity::class.java)
            startActivity(intent)
            finish()

        }
    }

    fun clickLogin (view: View){
        username = etUsername.text.toString()
        password = etPassword.text.toString()

        if (username == ""){
            etUsername.error = "Username is invalid"
            etUsername.requestFocus()
        } else if (username == ""){
            etPassword.error = "Password is invalid"
            etPassword.requestFocus()
        } else if (username != validUsername){
            etUsername.error = "Username is incorrect"
            etUsername.requestFocus()
        } else if (password != validPassword){
            etPassword.error = "Password is incorrect"
            etPassword.requestFocus()
        } else{
            prefManager.setLogin(true)
            prefManager.setUsername(username)

            val intent = Intent (this, MainActivity::class.java)
            startActivity(intent)
            finish()
        }
    }

}



























