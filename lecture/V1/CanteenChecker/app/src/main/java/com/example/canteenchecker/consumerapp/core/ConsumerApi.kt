package com.example.canteenchecker.consumerapp.core

interface ConsumerApi {
    fun getCanteens(
        filter: String,
    ): List<Canteen>
}