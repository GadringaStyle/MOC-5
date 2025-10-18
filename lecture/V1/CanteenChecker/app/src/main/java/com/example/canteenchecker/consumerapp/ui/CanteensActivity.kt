package com.example.canteenchecker.consumerapp.ui

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import com.example.canteenchecker.consumerapp.R
import com.example.canteenchecker.consumerapp.core.ConsumerApiFactory

class CanteensActivity : Activity() {
    private lateinit var edtSearch: EditText
    private lateinit var btnFoo: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_canteens)
        edtSearch = findViewById(R.id.edtSearch)
        btnFoo = findViewById(R.id.btnFoo)
        btnFoo.setOnClickListener {
            startActivity(CanteenDetailsActivity.intent(this, "123"))
        }
        findViewById<Button>(R.id.btnSearch).setOnClickListener { updateCanteens() }
        updateCanteens()
    }

    private fun updateCanteens() {
        val canteens = ConsumerApiFactory.createConsumerApi().getCanteens(edtSearch.text.toString())
        btnFoo.text = canteens.count().toString()
    }
}