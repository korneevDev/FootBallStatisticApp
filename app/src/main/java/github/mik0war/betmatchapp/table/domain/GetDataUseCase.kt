package github.mik0war.betmatchapp.table.domain

import github.mik0war.betmatchapp.table.data.TableRepository
import github.mik0war.betmatchapp.table.entityModel.TableDataUIModel
import javax.inject.Inject

class GetDataUseCase @Inject constructor(
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