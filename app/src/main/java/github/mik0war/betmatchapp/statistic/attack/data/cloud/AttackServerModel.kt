package github.mik0war.betmatchapp.statistic.attack.data.cloud

import com.google.gson.annotations.SerializedName
import github.mik0war.betmatchapp.statistic.entityModel.StatisticDataModel

data class AttackServerModel(
    @SerializedName("Команда")
    private val team: String,
    @SerializedName("Турнир")
    private val tournament: String,
    @SerializedName("Удары з.и.")
    private val kick: Float,
    @SerializedName("Удары ВСтв з.и.")
    private val kickInGateway: Float,
    @SerializedName("Дриблинг з.и.")
    private val dribbling: Float,
    @SerializedName("Дано фолов з.и.")
    private val foul: Float,
    @SerializedName("Рейтинг")
    private val rating: Float
) {
    fun toDataModel(): StatisticDataModel = StatisticDataModel.Attack(
        team, tournament, kick, kickInGateway, dribbling, foul, rating
    )
}