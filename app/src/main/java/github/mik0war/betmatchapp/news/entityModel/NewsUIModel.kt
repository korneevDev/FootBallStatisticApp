package github.mik0war.betmatchapp.news.entityModel

import android.widget.ImageView
import android.widget.TextView
import github.mik0war.betmatchapp.core.PicassoImageLoader

data class NewsUIModel(
    private val title: String,
    private val image_src: String,
    private val text: String,
    private val date: String
) {

    fun show(titleView: TextView, textView: TextView, dateView: TextView){
        titleView.text = title
        textView.text = text
        dateView.text = date
    }

    fun loadImage(imageView: ImageView, imageLoader: PicassoImageLoader){
        imageLoader.loadImage(image_src, imageView)
    }

}