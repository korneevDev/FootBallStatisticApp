package github.mik0war.betmatchapp.table.entityModel

import github.mik0war.betmatchapp.table.data.cache.TableCacheModel

class TableDataModel(
    private val id: Int,
    private val country: String,
    private val team: String,
    private val gamesCount: Int,
    private val wonGames: Int,
    private val drawGames: Int,
    private val loseGames: Int,
    private val balls: String,
    private val score: Int,
) {
    fun toUI() = TableDataUIModel(
        id.toString(),
        team,
        gamesCount.toString(),
        wonGames.toString(),
        drawGames.toString(),
        loseGames.toString(),
        balls,
        score.toString()
    )

    fun toCacheModel() =
        TableCacheModel(id, country, team, gamesCount, wonGames, drawGames, loseGames, balls, score)
}