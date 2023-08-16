package com.example.alomoves.ui.fragments

import androidx.annotation.LayoutRes
import androidx.fragment.app.Fragment
import androidx.navigation.NavDirections
import androidx.navigation.fragment.findNavController
import com.example.alomoves.utils.AppNavOptions
import com.example.alomoves.utils.Navigator

open class ParentFragment() : Fragment(), Navigator {
    override fun navigate(directions: NavDirections) {
        findNavController().navigate(directions, AppNavOptions)
    }

    override fun back() {
        findNavController().popBackStack()
    }
}