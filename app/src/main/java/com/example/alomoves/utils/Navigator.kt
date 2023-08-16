package com.example.alomoves.utils

import androidx.navigation.NavDirections
interface Navigator {
    fun navigate(directions: NavDirections)
    fun back()
}