package com.example.canteenchecker.adminapp.api

import com.example.canteenchecker.adminapp.models.CanteenData
import com.example.canteenchecker.adminapp.models.CanteenDetails
import com.example.canteenchecker.adminapp.models.CanteenReviewStatistics
import com.example.canteenchecker.adminapp.models.ReviewData
import java.time.OffsetDateTime
import java.util.LinkedList

class InMemoryAdministrationApiService : IAdministrationApi {
    private var canteenData: List<CanteenData> = LinkedList()
    private var details: CanteenDetails = CanteenDetails("hacker canteen", "trojan street 1, 1231 malware road", "+001234/11001023", "http://www.google.com", "EternalBlue", 12.34, 15)
    private var reviewStatistics: CanteenReviewStatistics = CanteenReviewStatistics(4, 3, 1, 2, 1)

    private var reviews = mutableListOf(
        ReviewData(0, OffsetDateTime.now(), "test1", 1, "ok"),
        ReviewData(1, OffsetDateTime.now(), "test2", 3, "ok"),
        ReviewData(2, OffsetDateTime.now(), "test3", 5, "ok"),
    )

    constructor(){

    }
    override fun authenticate(userName: String, password: String): Boolean {
        return userName == "admin" && password == "admin"
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
        return reviews
    }

    override fun deleteCanteenReviewById(reviewId: Int) {
        val obj = reviews.find { x -> x.id == reviewId}
        if(obj != null)
            reviews.remove(obj)
    }
}