package github.mik0war.betmatchapp.table.data.cache

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query

@Dao
interface TableDAO {

    @Insert
    suspend fun saveTableData(cacheModel: TableCacheModel)

    @Query("SELECT * FROM countryTeams WHERE country=:country")
    suspend fun getCountryData(country: String): List<TableCacheModel>

    @Query("DELETE FROM countryTeams")
    suspend fun clearDB()
}