package com.example.submissionapk

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class Shoe(var name: String, var description: String, var photo: Int): Parcelable {
}

