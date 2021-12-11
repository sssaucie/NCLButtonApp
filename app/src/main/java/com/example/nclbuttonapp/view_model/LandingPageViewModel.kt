package com.example.nclbuttonapp.view_model

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.nclbuttonapp.model.entity.ShipEntity
import com.example.nclbuttonapp.network.ShipsApi
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.Job
import kotlinx.coroutines.launch

class LandingPageViewModel: ViewModel() {

    private val TAG = LandingPageViewModel::class.java.simpleName
    private var viewModelJob = Job()
    private val coroutineScope = CoroutineScope(viewModelJob + Dispatchers.Main)

    private val _navigateToSelectedShipDetails = MutableLiveData<ShipEntity?>()

    val navigateToSelectedShipDetails: LiveData<ShipEntity?>
        get() = _navigateToSelectedShipDetails

    /**
     * Was going to make this a one-fragment app, but decided to show I know
     * navigation instead.
     */
//    fun displayShipDetails(selectedShip: ShipEntity) {
//        _navigateToSelectedShipDetails.value = selectedShip
//        Log.i(TAG, "Ship selected: ${selectedShip.shipName}")
//    }

    private val _selectedShip = MutableLiveData<ShipEntity?>()
    val selectedShip: LiveData<ShipEntity?>
        get() = _selectedShip

    init {
        _selectedShip.value = null
    }

    /**
     * Again, definitely there must be a better way to do this, let's talk about it!
     * Getting my internet to work and moving and interviewing made my timeframe far less
     * than I would have taken on this project, so I just went with what I knew already.
     */

    fun fetchSkyDetails() {
        coroutineScope.launch {
            val getShipDeferred = ShipsApi.retrofitService.getSky()
            try {
                val shipResult = getShipDeferred.await()
                _selectedShip.value = shipResult
                _navigateToSelectedShipDetails.value = shipResult
                Log.i(TAG, "Ship selected: ${shipResult.shipName}")
            } catch (e: Exception) {
                _selectedShip.value = null
                Log.i(TAG, "Unable to find ship information. Error: $e")
            }
        }
    }

    fun fetchBlissDetails() {
        coroutineScope.launch {
            val getShipDeferred = ShipsApi.retrofitService.getBliss()
            try {
                val shipResult = getShipDeferred.await()
                _selectedShip.value = shipResult
                _navigateToSelectedShipDetails.value = shipResult
                Log.i(TAG, "Ship selected: ${shipResult.shipName}")
            } catch (e: Exception) {
                _selectedShip.value = null
                Log.i(TAG, "Unable to find ship information. Error: $e")
            }
        }
    }

    fun fetchEscapeDetails() {
        coroutineScope.launch {
            val getShipDeferred = ShipsApi.retrofitService.getEscape()
            try {
                val shipResult = getShipDeferred.await()
                _selectedShip.value = shipResult
                _navigateToSelectedShipDetails.value = shipResult
                Log.i(TAG, "Ship selected: ${shipResult.shipName}")
            } catch (e: Exception) {
                _selectedShip.value = null
                Log.i(TAG, "Unable to find ship information. Error: $e")
            }
        }
    }

    fun onNavigated() {
        _navigateToSelectedShipDetails.value = null
        Log.i(TAG, "Navigated.")
    }
}