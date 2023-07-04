package github.mik0war.betmatchapp.statistic.defence.domain

import github.mik0war.betmatchapp.statistic.defence.data.DefenceRepository
import github.mik0war.betmatchapp.statistic.entityModel.StatisticUIModel

class DefenceUseCase(
    private val repository: DefenceRepository
) {
    suspend fun loadDefenceData(): List<StatisticUIModel> =
        listOf(
            StatisticUIModel.Defence(
                "Команда", "Турнир", "Удары з.и.", "Отборы з.и."
            )
        ) +
                repository.loadDefenceData().map { it.toUI() }
}