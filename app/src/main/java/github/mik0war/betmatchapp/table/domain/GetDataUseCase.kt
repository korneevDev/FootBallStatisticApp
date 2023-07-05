package github.mik0war.betmatchapp.table.domain

import github.mik0war.betmatchapp.table.data.TableRepository
import github.mik0war.betmatchapp.table.entityModel.TableDataUIModel

class GetDataUseCase(
    private val tableRepository: TableRepository
) {
    suspend fun getData(country: String): List<TableDataUIModel> =
        listOf(
            TableDataUIModel(
                "№",
                "Команда",
                "И",
                "В",
                "Н",
                "П",
                "Мячи",
                "О"
            )
        ) + tableRepository.getData(country).map { it.toUI() }
}