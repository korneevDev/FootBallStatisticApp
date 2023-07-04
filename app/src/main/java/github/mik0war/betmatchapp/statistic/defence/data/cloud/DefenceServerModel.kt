package github.mik0war.betmatchapp.statistic.defence.data.cloud

import com.google.gson.annotations.SerializedName
import github.mik0war.betmatchapp.statistic.entityModel.StatisticDataModel

data class DefenceServerModel(
    @SerializedName("Команда")
    private val team: String,
    @SerializedName("Турнир")
    private val tournament: String,
    @SerializedName("Удары з.и.")
    private val kick: Float,
    @SerializedName("Отборы з.и.")
    private val tackle: Float,
    @SerializedName("Перехваты з.и.")
    private val interception: Float,
    @SerializedName("Фолы з.и.")
    private val foul: Float,
    @SerializedName("Офсайды з.и")
    private val offside: Float,
    @SerializedName("Рейтинг")
    private val rating: Float
) {
    fun toDataModel(): StatisticDataModel = StatisticDataModel.Defence(
        team,
        tournament,
        kick,
        tackle,
        interception,
        foul,
        offside,
        rating
    )
}