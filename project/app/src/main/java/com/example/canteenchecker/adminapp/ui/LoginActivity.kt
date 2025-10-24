package com.example.canteenchecker.adminapp.ui

import android.app.Activity
import android.app.AlertDialog
import android.content.DialogInterface
import android.os.Bundle
import android.os.Debug
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.activity.ComponentActivity
import com.example.canteenchecker.adminapp.R
import com.example.canteenchecker.adminapp.api.IAdministrationApi
import dagger.hilt.android.AndroidEntryPoint
import java.io.Console
import javax.inject.Inject

@AndroidEntryPoint
class LoginActivity : ComponentActivity() {
    @Inject lateinit var apiService: IAdministrationApi
    private lateinit var btnLogin: Button
    private lateinit var edtUserName: EditText
    private lateinit var edtPassword: EditText
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)
        btnLogin = findViewById(R.id.btnLogin)
        edtUserName = findViewById(R.id.edtUserName)
        edtPassword = findViewById(R.id.edtPassword)
        btnLogin.setOnClickListener {
            if(apiService.authenticate(edtUserName.text.toString(), edtPassword.text.toString())){
                startActivity(OverviewActivity.intent(this))
            }
            else{
                Toast.makeText(this, "invalid credentials!", Toast.LENGTH_SHORT).show()
            }
        }
    }
}