package com.example.canteenchecker.adminapp.ui

import android.app.Activity
import android.os.Bundle
import android.os.Debug
import android.widget.Button
import androidx.activity.ComponentActivity
import com.example.canteenchecker.adminapp.R
import com.example.canteenchecker.adminapp.api.IAdministrationApi
import dagger.hilt.android.AndroidEntryPoint
import java.io.Console
import javax.inject.Inject

@AndroidEntryPoint
class LoginActivity : ComponentActivity() {
    @Inject lateinit var apiService: IAdministrationApi
    private lateinit var btnLogin: Button;
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)
        btnLogin = findViewById(R.id.btnLogin)
        btnLogin.setOnClickListener {
            if(onLogin()){
                System.out.println(apiService.getCanteenReviews().size)
            }
            else{

            }
        }
    }

    fun onLogin(): Boolean{
        return true;
    }
}