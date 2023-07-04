package github.mik0war.betmatchapp.news.entityModel

data class NewsDataModel(
    private val title: String,
    private val image_src: String,
    private val text: String,
    private val date: String
) {
    fun toUI() = NewsUIModel(title, image_src, text, date)
}