package github.mik0war.betmatchapp.table.domain

import github.mik0war.betmatchapp.table.data.TableRepository

class LoadDataUseCase(
    private val repository: TableRepository
) {
    suspend fun loadData() = repository.loadData()
}