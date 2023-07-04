package github.mik0war.betmatchapp.news.presentation

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import github.mik0war.betmatchapp.R
import github.mik0war.betmatchapp.core.GetList
import github.mik0war.betmatchapp.core.PicassoImageLoader
import github.mik0war.betmatchapp.news.entityModel.NewsUIModel

class NewsListAdapter(
    private val newsList: GetList<NewsUIModel>,
    private val imageLoader: PicassoImageLoader
) : RecyclerView.Adapter<NewsViewHolder>() {

    @SuppressLint("NotifyDataSetChanged")
    fun update(){
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): NewsViewHolder =
        NewsViewHolder(
            imageLoader, LayoutInflater.from(parent.context)
                .inflate(R.layout.news_item, parent, false)
        )

    override fun getItemCount(): Int = newsList.getList().size

    override fun onBindViewHolder(holder: NewsViewHolder, position: Int) {
        holder.bind(newsList.getList()[position])
    }
}

class NewsViewHolder(
    private val imageLoader: PicassoImageLoader,
    view: View
) : RecyclerView.ViewHolder(view) {

    fun bind(uiModel: NewsUIModel) {
        val titleView = itemView.findViewById<TextView>(R.id.news_title)
        val textView = itemView.findViewById<TextView>(R.id.news_text)
        val dateView = itemView.findViewById<TextView>(R.id.news_date)
        val imageView = itemView.findViewById<ImageView>(R.id.news_image)

        uiModel.show(titleView, textView, dateView)
        uiModel.loadImage(imageView, imageLoader)
    }
}