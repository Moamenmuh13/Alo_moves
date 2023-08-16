package com.example.alomoves.utils

import androidx.navigation.NavOptions
import com.example.alomoves.R

val AppNavOptions = NavOptions.Builder()
    .setEnterAnim(R.anim.nav_slide_left)
    .setExitAnim(R.anim.nav_wait)
    .setPopEnterAnim(R.anim.nav_wait)
    .setPopExitAnim(R.anim.nav_slide_right)
    .build()
