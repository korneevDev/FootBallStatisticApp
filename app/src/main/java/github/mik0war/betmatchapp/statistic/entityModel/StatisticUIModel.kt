package github.mik0war.betmatchapp.statistic.entityModel

import android.widget.TextView

sealed interface StatisticUIModel {
    data class Defence(
        private val team: String,
        private val tournament: String,
        private val kick: String,
        private val tackle: String,
    ) : StatisticUIModel {
        fun show(
            teamView: TextView,
            tournamentView: TextView,
            kickView: TextView,
            tackleView: TextView,
        ){
            teamView.text = team
            tournamentView.text = tournament
            kickView.text = kick
            tackleView.text = tackle
        }
    }

    data class Attack(
        private val team: String,
        private val tournament: String,
        private val kick: String,
        private val rating: String,
    ) : StatisticUIModel {
        fun show(
            teamView: TextView,
            tournamentView: TextView,
            kickView: TextView,
            ratingView: TextView,
        ){
            teamView.text = team
            tournamentView.text = tournament
            kickView.text = kick
            ratingView.text = rating
        }
    }
}