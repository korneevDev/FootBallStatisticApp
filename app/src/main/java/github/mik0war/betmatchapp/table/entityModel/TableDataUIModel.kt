package github.mik0war.betmatchapp.table.entityModel

import android.widget.TextView

data class TableDataUIModel(
    private val id: String,
    private val team: String,
    private val gamesCount: String,
    private val wonGames: String,
    private val drawGames: String,
    private val loseGames: String,
    private val balls: String,
    private val score: String,
) {
    fun show(
        idView: TextView,
        teamView: TextView,
        gamesCountView: TextView,
        wonView: TextView,
        drawView: TextView,
        loseView: TextView,
        ballsView: TextView,
        scoreView: TextView
    ){
        idView.text = id
        teamView.text = team
        gamesCountView.text = gamesCount
        wonView.text = wonGames
        drawView.text = drawGames
        loseView.text = loseGames
        ballsView.text = balls
        scoreView.text = score
    }
}