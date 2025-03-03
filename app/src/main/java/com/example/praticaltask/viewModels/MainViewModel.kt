package com.example.praticaltask.viewModels

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.praticaltask.MainViewRepository
import com.example.praticaltask.models.DataModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch

class MainViewModel : ViewModel(){

    private val repository = MainViewRepository()
    private val _currencyApiResponse = MutableStateFlow(DataModel(""))
    val currencyApiResponse: StateFlow<DataModel> get() = _currencyApiResponse

    fun checkAndFetchCurrencyData(lastTimeSaved: String, apikey: String) {

        if(lastTimeSaved.isEmpty()){
            fetchCurrencyData(apikey)
        }
    }

    private fun fetchCurrencyData(apikey: String) {
        viewModelScope.launch {
            repository.getCurrencyLatest(apikey).collect { apiResponse ->
                _currencyApiResponse.emit(apiResponse)
            }
        }
    }



}