package com.example.canteenchecker.consumerapp.core

import com.example.canteenchecker.consumerapp.infrastructure.ConsumerApiImplementation

object ConsumerApiFactory {
    fun createConsumerApi(): ConsumerApi = ConsumerApiImplementation()
}