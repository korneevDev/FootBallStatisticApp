package github.mik0war.betmatchapp.news.data.cloud

import github.mik0war.betmatchapp.news.entityModel.NewsDataModel

class NewsCloudDataSource(
    private val newsService: NewsService
) {
    suspend fun loadData(): List<NewsDataModel> = newsService.getNews().map { it.toDataModel() }
}
