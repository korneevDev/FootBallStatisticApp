package github.mik0war.betmatchapp.core

import androidx.lifecycle.LifecycleOwner
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Observer

abstract class CommonLiveData<T> : GetList<T> {
    private val data = MutableLiveData<List<T>>()

    fun updateData(dataList: List<T>){
        this.data.value = dataList
    }

    fun observe(owner: LifecycleOwner, observer: Observer<List<T>>) =
        data.observe(owner, observer)

    override fun getList(): List<T> = data.value ?: emptyList()
}