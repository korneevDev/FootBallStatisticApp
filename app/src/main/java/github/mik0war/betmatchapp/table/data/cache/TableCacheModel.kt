package github.mik0war.betmatchapp.table.data.cache

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import github.mik0war.betmatchapp.table.entityModel.TableDataModel

@Entity(tableName = "countryTeams")
data class TableCacheModel(
    @ColumnInfo(name = "number") val num: Int,
    @ColumnInfo(name = "country") val country: String,
    @ColumnInfo(name = "team") val team: String,
    @ColumnInfo(name = "gamesCount") val gamesCount: Int,
    @ColumnInfo(name = "wonGames") val wonGames: Int,
    @ColumnInfo(name = "drawGames") val drawGames: Int,
    @ColumnInfo(name = "loseGames") val loseGames: Int,
    @ColumnInfo(name = "balls") val balls: String,
    @ColumnInfo(name = "score") val score: Int
) {
    @PrimaryKey(autoGenerate = true) var id: Int = 0
    fun toDataModel() =
        TableDataModel(num, country, team, gamesCount, wonGames, drawGames, loseGames, balls, score)
}