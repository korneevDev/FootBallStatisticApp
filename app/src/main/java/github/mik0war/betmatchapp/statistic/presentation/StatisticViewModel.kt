package github.mik0war.betmatchapp.statistic.presentation

import androidx.lifecycle.LifecycleOwner
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import github.mik0war.betmatchapp.core.CommonLiveData
import github.mik0war.betmatchapp.core.GetList
import github.mik0war.betmatchapp.statistic.attack.domain.AttackUseCase
import github.mik0war.betmatchapp.statistic.defence.domain.DefenceUseCase
import github.mik0war.betmatchapp.statistic.entityModel.StatisticUIModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import javax.inject.Inject

class StatisticViewModel @Inject constructor(
    private val liveData: StatisticLiveData,
    private val attackUseCase: AttackUseCase,
    private val defenceUseCase: DefenceUseCase
) : ViewModel(), GetList<StatisticUIModel>{

    fun observe(owner: LifecycleOwner, observer: Observer<List<StatisticUIModel>>){
        liveData.observe(owner, observer)
    }

    fun loadDefenceData() = viewModelScope.launch(Dispatchers.Main) {
        liveData.updateData(defenceUseCase.loadDefenceData())
    }

    fun loadAttackData() = viewModelScope.launch(Dispatchers.Main) {
        liveData.updateData(attackUseCase.loadAttackData())
    }

    override fun getList(): List<StatisticUIModel> = liveData.getList()
}

class StatisticLiveData  @Inject constructor(): CommonLiveData<StatisticUIModel>()