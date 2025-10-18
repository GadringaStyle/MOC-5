package com.example.canteenchecker.consumerapp.infrastructure

import com.example.canteenchecker.consumerapp.core.Canteen
import com.example.canteenchecker.consumerapp.core.ConsumerApi
import kotlinx.coroutines.flow.asFlow
import kotlinx.coroutines.flow.filter

class ConsumerApiImplementation : ConsumerApi {
    override fun getCanteens(filter: String): List<Canteen>{
        return listOf(
            Canteen("1", "Foo", "Dish", 100.0f, 3.5f),
            Canteen("2", "Bar", "Dish", 100.0f, 3.5f),
            Canteen("3", "\uD83D\uDE19", "Dish", 100.0f, 3.5f)
        ).filter { canteen -> canteen.name.contains(filter)}
    }
}