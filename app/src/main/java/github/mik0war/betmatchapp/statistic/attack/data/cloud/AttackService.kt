package github.mik0war.betmatchapp.statistic.attack.data.cloud

import retrofit2.http.GET

interface AttackService {

    @GET("data_statistic_attack.json")
    suspend fun loadAttackData(): List<AttackServerModel>
}