package com.example.diploma.model

import androidx.annotation.DrawableRes

data class New(
    val title: String,
    @DrawableRes
    val image: Int,
    val text: String
)