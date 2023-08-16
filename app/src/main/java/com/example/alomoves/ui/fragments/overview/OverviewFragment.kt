package com.example.alomoves.ui.fragments.overview

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.navigation.fragment.findNavController
import com.example.alomoves.R
import com.example.alomoves.databinding.FragmentOverviewBinding
import com.example.alomoves.ui.fragments.ParentFragment

class OverviewFragment : ParentFragment() {
    private lateinit var binding: FragmentOverviewBinding
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentOverviewBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.textView.text = arguments?.let {
            OverviewFragmentArgs.fromBundle(it).classDescription
        }
    }
}