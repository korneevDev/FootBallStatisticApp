package github.mik0war.betmatchapp.table.domain

import github.mik0war.betmatchapp.table.data.TableRepository
import javax.inject.Inject

class LoadDataUseCase @Inject constructor(
    private val repository: TableRepository
) {
    suspend fun loadData() = repository.loadData()
}