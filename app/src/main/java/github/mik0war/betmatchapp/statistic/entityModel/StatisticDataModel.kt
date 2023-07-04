package github.mik0war.betmatchapp.statistic.entityModel

sealed interface StatisticDataModel {

    fun toUI(): StatisticUIModel

    data class Defence(
        private val team: String,
        private val tournament: String,
        private val kick: Float,
        private val tackle: Float,
        private val interception: Float,
        private val foul: Float,
        private val offside: Float,
        private val rating: Float
    ) : StatisticDataModel {
        override fun toUI() = StatisticUIModel.Defence(
            team,
            tournament,
            kick.toString(),
            tackle.toString()
        )
    }

    data class Attack(
        private val team: String,
        private val tournament: String,
        private val kick: Float,
        private val kickInGateway: Float,
        private val dribbling: Float,
        private val foul: Float,
        private val rating: Float
    ) : StatisticDataModel {
        override fun toUI() = StatisticUIModel.Attack(
            team,
            tournament,
            kick.toString(),
            rating.toString()
        )
    }
}