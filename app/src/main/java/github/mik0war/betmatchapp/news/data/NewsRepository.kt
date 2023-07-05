package github.mik0war.betmatchapp.news.data

import github.mik0war.betmatchapp.news.data.cloud.NewsCloudDataSource
import github.mik0war.betmatchapp.news.entityModel.NewsDataModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import javax.inject.Inject

class NewsRepository@Inject constructor(
    private val cloudDataSource: NewsCloudDataSource
) {
    suspend fun getNews(): List<NewsDataModel> = withContext(Dispatchers.IO){
        cloudDataSource.loadData()
    }

}