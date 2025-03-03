package com.example.praticaltask

import com.example.praticaltask.models.DataModel
import com.example.praticaltask.apiService.ApiClient
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow

class MainViewRepository {
    private val apiService = ApiClient.getClient()

    fun getCurrencyLatest(apiKey: String): Flow<DataModel> = flow {
        apiService.getCurrencyLatest(apiKey)?.let { emit(it) } // Fetch data and emit as Flow
    }
}