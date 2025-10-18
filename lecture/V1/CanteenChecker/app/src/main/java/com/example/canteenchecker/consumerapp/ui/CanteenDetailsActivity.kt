package com.example.canteenchecker.consumerapp.ui

import android.app.Activity
import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.widget.TextView
import com.example.canteenchecker.consumerapp.R

class CanteenDetailsActivity : Activity() {

    private lateinit var txvName: TextView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_canteen_details)
        txvName = findViewById(R.id.txtName)
        updateCanteenDetails()
    }

    private fun updateCanteenDetails(){
        //TODO: continue here
        val canteenId = intent.getStringExtra(CANTEEN_ID) ?: ""
        txvName.text = canteenId
    }

    companion object {
        private const val CANTEEN_ID = "CanteenId"

        fun intent(context: Context, canteenId: String): Intent = Intent(context, CanteenDetailsActivity::class.java).apply {
            putExtra(CANTEEN_ID, canteenId)
        }
    }
}