package github.mik0war.betmatchapp.statistic.defence.data.cloud

import retrofit2.http.GET

interface DefenceService {

    @GET("data_statistic_defense.json")
    suspend fun loadDefenseData(): List<DefenceServerModel>
}