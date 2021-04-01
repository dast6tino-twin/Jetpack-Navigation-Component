package ru.dast_6_tino.androidx_navigation_example.main.list

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class Dog(
    val id: Long,
    val name: String,
    val breed: String,
    val description: String
) : Parcelable
