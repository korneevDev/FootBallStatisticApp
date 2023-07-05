package github.mik0war.betmatchapp.news.presentation

import androidx.lifecycle.LifecycleOwner
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import github.mik0war.betmatchapp.core.CommonLiveData
import github.mik0war.betmatchapp.core.GetList
import github.mik0war.betmatchapp.news.data.NewsRepository
import github.mik0war.betmatchapp.news.entityModel.NewsUIModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import javax.inject.Inject

class NewsViewModel @Inject constructor(
    private val repository: NewsRepository,
    private val liveData: NewsLiveData
): ViewModel(), GetList<NewsUIModel> {

    fun loadNews() = viewModelScope.launch(Dispatchers.Main) {
        liveData.updateData(repository.getNews().map { it.toUI() })
    }

    fun observe(owner: LifecycleOwner, observer: Observer<List<NewsUIModel>>) =
        liveData.observe(owner, observer)

    override fun getList(): List<NewsUIModel> = liveData.getList()
}

class NewsLiveData @Inject constructor(): CommonLiveData<NewsUIModel>()