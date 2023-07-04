package github.mik0war.betmatchapp.core

import android.widget.ImageView
import com.squareup.picasso.Picasso

class PicassoImageLoader {
    fun loadImage(imageUrl: String, imageView: ImageView) {
        Picasso.get()
            .load(imageUrl)
            .into(imageView)
    }
}