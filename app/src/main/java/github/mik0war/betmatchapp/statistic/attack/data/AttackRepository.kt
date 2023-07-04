package github.mik0war.betmatchapp.statistic.attack.data

import github.mik0war.betmatchapp.statistic.attack.data.cloud.AttackService
import github.mik0war.betmatchapp.statistic.entityModel.StatisticDataModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class AttackRepository(
    private val service: AttackService
) {
    suspend fun loadAttackData(): List<StatisticDataModel> = withContext(Dispatchers.IO){
        return@withContext service.loadAttackData().map { it.toDataModel() }
    }
}