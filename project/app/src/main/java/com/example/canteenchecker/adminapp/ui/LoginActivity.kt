package com.example.canteenchecker.adminapp.ui

import android.app.Activity
import android.os.Bundle
import android.widget.Button
import com.example.canteenchecker.adminapp.R

class LoginActivity : Activity() {
    private lateinit var btnLogin: Button;
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activitiy_login)
        btnLogin = findViewById(R.id.btnLogin)
        btnLogin.setOnClickListener {
            if(onLogin()){

            }
            else{

            }
        }
    }

    fun onLogin(): Boolean{
        return true;
    }
}