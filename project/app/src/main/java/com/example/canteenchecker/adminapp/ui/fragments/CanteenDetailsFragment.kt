package com.example.canteenchecker.adminapp.ui.fragments

import android.os.Bundle
import android.text.InputType
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.EditText
import android.widget.GridLayout
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.fragment.app.viewModels
import com.example.canteenchecker.adminapp.R
import com.example.canteenchecker.adminapp.api.IAdministrationApi
import com.example.canteenchecker.adminapp.databinding.FragmentCanteenDetailsBinding
import com.example.canteenchecker.adminapp.misc.EditTextWithSuffix
import com.example.canteenchecker.adminapp.ui.viewmodels.OverviewViewModel
import com.google.android.material.card.MaterialCardView
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject

@AndroidEntryPoint
class CanteenDetailsFragment : Fragment(){
    @Inject lateinit var apiService: IAdministrationApi
    private val viewModel: OverviewViewModel by viewModels()
    private lateinit var binding: FragmentCanteenDetailsBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_canteen_details, container, false)
        binding.lifecycleOwner = viewLifecycleOwner  // ✅ Needed for LiveData to auto-update
        binding.viewModel = viewModel                // ✅ Bind ViewModel to layout
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setupData()
    }

    private fun setupData(){
        viewModel.canteenDetails.value = apiService.getCanteenDetails()
    }
}