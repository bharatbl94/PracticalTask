package com.example.praticaltask.apiService

import com.example.praticaltask.models.DataModel
import retrofit2.http.GET
import retrofit2.http.Query

interface ApiService {
    @GET("api/latest.json")
    suspend fun getCurrencyLatest(@Query("app_id") appId: String): DataModel?
}
