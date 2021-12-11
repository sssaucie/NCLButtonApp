package com.example.nclbuttonapp.view

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import com.example.nclbuttonapp.R
import com.example.nclbuttonapp.databinding.FragmentLandingPageBinding
import com.example.nclbuttonapp.view_model.LandingPageViewModel

class LandingPageFragment: Fragment() {

    private val viewModel: LandingPageViewModel by lazy {
        ViewModelProvider(this).get(LandingPageViewModel::class.java)
    }
    private val TAG = LandingPageFragment::class.java.simpleName

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val binding: FragmentLandingPageBinding = DataBindingUtil.inflate(
            inflater, R.layout.fragment_landing_page, container, false)
        binding.lifecycleOwner = this
        binding.viewModel = viewModel

        val blissButton: Button = binding.buttonLandingPageBliss
        val escapeButton: Button = binding.buttonLandingPageEscape
        val skyButton: Button = binding.buttonLandingPageSky

        blissButton.setOnClickListener {
            Log.i(TAG, "Bliss Button clicked")
        }
        escapeButton.setOnClickListener {
            Log.i(TAG, "Escape Button clicked")
        }
        skyButton.setOnClickListener {
            Log.i(TAG, "Sky Button clicked")
        }

        viewModel.navigateToSelectedShipDetails.observe(viewLifecycleOwner, {
            if (null != it) {
                this.findNavController().navigate(
                    LandingPageFragmentDirections.actionShowShipDetail(it))
                viewModel.onNavigated()
            }
        })

        return binding.root
    }
}