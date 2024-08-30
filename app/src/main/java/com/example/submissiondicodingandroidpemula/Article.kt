package com.example.submissiondicodingandroidpemula

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class Article (
    val title: String,
    val description: String,
    val image: String,
): Parcelable