package com.example.canteenchecker.adminapp.ui.viewmodels

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.canteenchecker.adminapp.models.CanteenDetails

class OverviewViewModel : ViewModel() {
    val canteenDetails = MutableLiveData<CanteenDetails>()
}