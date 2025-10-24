package com.example.canteenchecker.adminapp.api

import CanteenData
import CanteenDetails
import CanteenReviewStatistics
import ReviewData
import java.util.LinkedList

class InMemoryAdministrationApiService : IAdministrationApi {
    private var canteenData: List<CanteenData> = LinkedList()
    private var details: CanteenDetails = CanteenDetails("hacker canteen", "trojan street 1, 1231 malware road", "+001234/11001023", "http://www.google.com", "EternalBlue", 12.34, 15)
    private var reviewStatistics: CanteenReviewStatistics = CanteenReviewStatistics(4, 3, 1, 2, 1)
    constructor(){

    }
    override fun authenticate(userName: String, password: String): Boolean {
        return true
    }

    override fun getCanteenDetails(): CanteenDetails {
        return details
    }

    override fun getReviewStatistics(): CanteenReviewStatistics {
        return reviewStatistics
    }

    override fun updateCanteenDetails(
        name: String,
        address: String,
        website: String,
        phoneNumber: String
    ) {
        details.name = name;
        details.address = address
        details.website = website
        details.phoneNumber = phoneNumber
    }

    override fun updateDish(dish: String, newPrice: Double) {
        val data = canteenData.find { canteenData -> canteenData.name === dish }
        if(data != null){
            data.dishPrice = newPrice
        }
    }

    override fun updateWaitingTime(newWaitingTime: Int) {
        details.waitingTime = newWaitingTime
    }

    override fun getCanteenReviews(): List<ReviewData> {
        TODO("Not yet implemented")
    }

    override fun deleteCanteenReviewById(reviewId: Int) {
        TODO("Not yet implemented")
    }
}