package github.mik0war.betmatchapp.statistic.attack.domain

import github.mik0war.betmatchapp.statistic.attack.data.AttackRepository
import github.mik0war.betmatchapp.statistic.entityModel.StatisticUIModel

class AttackUseCase(
    private val repository: AttackRepository
) {
    suspend fun loadAttackData() : List<StatisticUIModel> =
        listOf(
            StatisticUIModel.Attack(
                "Команда", "Турнир", "Удары з.и.", "Рейтинг"
            )
        ) +
        repository.loadAttackData().map { it.toUI() }
}