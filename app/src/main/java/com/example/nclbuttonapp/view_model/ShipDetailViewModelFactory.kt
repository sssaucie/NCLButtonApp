package com.example.nclbuttonapp.view_model

import android.app.Application
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.nclbuttonapp.model.entity.ShipEntity

class ShipDetailViewModelFactory(
    private val ship: ShipEntity,
    private val application: Application
): ViewModelProvider.Factory {
    @Suppress("unchecked_cast")
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(ShipDetailViewModel::class.java)) {
            return ShipDetailViewModel(ship, application) as T
        }
        throw IllegalArgumentException("Unknown ViewModel class")
    }
}