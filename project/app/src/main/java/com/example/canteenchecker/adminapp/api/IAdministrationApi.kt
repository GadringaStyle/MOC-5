package com.example.canteenchecker.adminapp.api

import com.example.canteenchecker.adminapp.models.CanteenDetails
import com.example.canteenchecker.adminapp.models.CanteenReviewStatistics
import com.example.canteenchecker.adminapp.models.ReviewData

interface IAdministrationApi {
    fun authenticate(userName: String, password: String): Boolean
    fun getCanteenDetails(): CanteenDetails
    fun getReviewStatistics(): CanteenReviewStatistics
    fun updateCanteenDetails(name: String, address: String,
                          website: String, phoneNumber: String)
    fun updateDish(dish: String, newPrice: Double)
    fun updateWaitingTime(newWaitingTime: Int)
    fun getCanteenReviews(): List<ReviewData>
    fun deleteCanteenReviewById(reviewId: Int)
}