package github.mik0war.betmatchapp.news.data.cloud

import retrofit2.http.GET

interface NewsService {

    @GET("news.json")
    suspend fun getNews(): List<NewsServerModel>
}