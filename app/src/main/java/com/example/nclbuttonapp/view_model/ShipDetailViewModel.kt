package com.example.nclbuttonapp.view_model

import android.app.Application
import android.util.Log
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.nclbuttonapp.model.entity.ShipEntity
import com.example.nclbuttonapp.network.ShipsApi
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.Job
import kotlinx.coroutines.launch

class ShipDetailViewModel(ship: ShipEntity, application: Application)
    : AndroidViewModel(application) {
    private val TAG = ShipDetailViewModel::class.java.simpleName
    private val _selectedShip = MutableLiveData<ShipEntity>()

    val selectedShip: LiveData<ShipEntity>
        get() = _selectedShip

    init {
        _selectedShip.value = ship
    }
}