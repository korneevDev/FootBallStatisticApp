package github.mik0war.betmatchapp.news.presentation

import androidx.lifecycle.LifecycleOwner
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import github.mik0war.betmatchapp.core.GetList
import github.mik0war.betmatchapp.news.data.NewsRepository
import github.mik0war.betmatchapp.news.entityModel.NewsUIModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class NewsViewModel(
    private val repository: NewsRepository,
    private val liveData: NewsLiveData
): ViewModel(), GetList<NewsUIModel> {

    fun loadNews() = viewModelScope.launch(Dispatchers.Main) {
        liveData.updateNews(repository.getNews().map { it.toUI() })
    }

    fun observe(owner: LifecycleOwner, observer: Observer<List<NewsUIModel>>) =
        liveData.observeNews(owner, observer)

    override fun getList(): List<NewsUIModel> = liveData.getList()
}