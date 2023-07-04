package github.mik0war.betmatchapp.news.data.cloud

import com.google.gson.annotations.SerializedName
import github.mik0war.betmatchapp.news.entityModel.NewsDataModel

data class NewsServerModel(
    @SerializedName("tittle")
    private val title: String,
    @SerializedName("text")
    private val text: String,
    @SerializedName("date")
    private val date: String,
    @SerializedName("img")
    private val imageURL: String,

) {
    fun toDataModel() = NewsDataModel(title, imageURL, text, date)
}