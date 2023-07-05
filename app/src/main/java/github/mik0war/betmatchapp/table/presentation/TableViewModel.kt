package github.mik0war.betmatchapp.table.presentation

import androidx.lifecycle.LifecycleOwner
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import github.mik0war.betmatchapp.core.CommonLiveData
import github.mik0war.betmatchapp.core.GetList
import github.mik0war.betmatchapp.table.domain.GetDataUseCase
import github.mik0war.betmatchapp.table.domain.LoadDataUseCase
import github.mik0war.betmatchapp.table.entityModel.TableDataUIModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class TableViewModel(
    private val getDataUseCase: GetDataUseCase,
    private val loadDataUseCase: LoadDataUseCase,
    private val tableLiveData: TableLiveData
): ViewModel(), GetList<TableDataUIModel> {

    fun loadData() = viewModelScope.launch(Dispatchers.Main) {
        loadDataUseCase.loadData()
    }

    fun getData(country: String) = viewModelScope.launch(Dispatchers.Main) {
        tableLiveData.updateData(getDataUseCase.getData(country))
    }

    override fun getList(): List<TableDataUIModel> = tableLiveData.getList()

    fun observe(owner: LifecycleOwner, observer: Observer<List<TableDataUIModel>>){
        tableLiveData.observe(owner, observer)
    }
}

class TableLiveData : CommonLiveData<TableDataUIModel>()