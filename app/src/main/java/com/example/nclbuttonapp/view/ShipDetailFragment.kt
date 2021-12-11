package com.example.nclbuttonapp.view

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.example.nclbuttonapp.R
import com.example.nclbuttonapp.databinding.FragmentShipDetailBinding
import com.example.nclbuttonapp.model.entity.ShipEntity
import com.example.nclbuttonapp.view_model.ShipDetailViewModel
import com.example.nclbuttonapp.view_model.ShipDetailViewModelFactory

class ShipDetailFragment: Fragment() {
    private lateinit var selectedShip: ShipEntity
    private var TAG = ShipDetailFragment::class.java.simpleName

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        selectedShip = ShipDetailFragmentArgs.fromBundle(requireArguments()).selectedShip

        val binding: FragmentShipDetailBinding = DataBindingUtil.inflate(
            inflater, R.layout.fragment_ship_detail, container, false)

        val application = requireNotNull(this.activity).application

        val viewModelFactory = ShipDetailViewModelFactory(selectedShip, application)

        val shipDetailViewModel = ViewModelProvider(
            this, viewModelFactory)[ShipDetailViewModel::class.java]

        binding.viewModel = shipDetailViewModel

        binding.lifecycleOwner = this

        Log.i(TAG, "onCreateView complete")
        return binding.root
    }
}