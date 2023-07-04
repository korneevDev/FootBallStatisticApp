package github.mik0war.betmatchapp.statistic.presentation

import androidx.lifecycle.LifecycleOwner
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Observer
import github.mik0war.betmatchapp.core.GetList
import github.mik0war.betmatchapp.statistic.entityModel.StatisticUIModel

class StatisticLiveData : GetList<StatisticUIModel> {
    private val statistic = MutableLiveData<List<StatisticUIModel>>()

    fun updateData(statistic: List<StatisticUIModel>){
        this.statistic.value = statistic
    }

    fun observe(owner: LifecycleOwner, observer: Observer<List<StatisticUIModel>>) =
        statistic.observe(owner, observer)

    override fun getList(): List<StatisticUIModel> = statistic.value ?: emptyList()
}