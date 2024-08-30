package com.example.submissiondicodingandroidpemula

import android.widget.ImageView
import com.squareup.picasso.Picasso
import jp.wasabeef.picasso.transformations.RoundedCornersTransformation

class Util {
    companion object {

        fun loadImage(
            imageView: ImageView,
            imageUrl: String,
            placeholder: Int
        ) {
            Picasso.get()
                .load(imageUrl)
                .placeholder(placeholder)
                .error(placeholder)
                .fit()
                .centerCrop()
                .transform(RoundedCornersTransformation(12, 0))
                .into(imageView)
        }
    }
}
