package github.mik0war.betmatchapp.statistic.defence.data

import github.mik0war.betmatchapp.statistic.defence.data.cloud.DefenceService
import github.mik0war.betmatchapp.statistic.entityModel.StatisticDataModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import javax.inject.Inject

class DefenceRepository @Inject constructor(
    private val defenceService: DefenceService
) {
    suspend fun loadDefenceData(): List<StatisticDataModel> = withContext(Dispatchers.IO){
        return@withContext defenceService.loadDefenseData().map { it.toDataModel() }
    }
}