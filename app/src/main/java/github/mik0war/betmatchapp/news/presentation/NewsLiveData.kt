package github.mik0war.betmatchapp.news.presentation

import androidx.lifecycle.LifecycleOwner
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Observer
import github.mik0war.betmatchapp.core.GetList
import github.mik0war.betmatchapp.news.entityModel.NewsUIModel

class NewsLiveData : GetList<NewsUIModel> {
    private val news = MutableLiveData<List<NewsUIModel>>()

    fun updateNews(news: List<NewsUIModel>){
        this.news.value = news
    }

    fun observeNews(owner: LifecycleOwner, observer: Observer<List<NewsUIModel>>) =
        news.observe(owner, observer)

    override fun getList(): List<NewsUIModel> = news.value ?: emptyList()
}