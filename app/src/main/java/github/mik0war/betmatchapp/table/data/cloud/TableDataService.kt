package github.mik0war.betmatchapp.table.data.cloud

import retrofit2.http.GET

interface TableDataService {

    @GET("data_tournament_tables.json")
    suspend fun getData(): List<TableServerModel>
}