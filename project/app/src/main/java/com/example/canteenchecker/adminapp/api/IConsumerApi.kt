package com.example.canteenchecker.adminapp.api

interface IConsumerApi {
    fun authenticate(userName: String, password: String)
    fun getCanteens(name: String?)
    fun getCanteenById(canteenId: String)
    fun getReviewStatisticsByCanteenId(canteenId: String)
    fun addReviewToCanteenById(canteenId: String, rating: String, remark: String)
}