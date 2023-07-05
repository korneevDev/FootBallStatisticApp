package github.mik0war.betmatchapp.table.data.cloud

import com.google.gson.annotations.SerializedName
import github.mik0war.betmatchapp.table.core.CountryEnum
import github.mik0war.betmatchapp.table.entityModel.TableDataModel

data class TableServerModel(
    @SerializedName("name")
    private val country: String,
    @SerializedName("dates")
    private val dates: String,
    @SerializedName("category")
    private val category: String,
    @SerializedName("players_count")
    private val playersCount: Int,
    @SerializedName("icon")
    private val icon: String,
    @SerializedName("data")
    private val teams: TeamList,
) {

    fun mapToDataModelList(): List<TableDataModel> =
        mutableListOf<TableDataModel>().also { list ->
            teams.toList().forEach { team ->
                list.add(
                    TableDataModel(
                        team.first,
                        countryName(),
                        team.second.name,
                        team.second.games,
                        team.second.won,
                        team.second.draw,
                        team.second.lose,
                        team.second.balls,
                        team.second.score
                    )
                )
            }
        }

    private fun countryName(): String =
        when (country) {
            "Англия - Премьер-лига" -> CountryEnum.ENGLAND.name
            "Россия - Премьер-Лига" -> CountryEnum.RUSSIA.name
            "Испания - Примера" -> CountryEnum.SPAIN.name
            "Германия - Бундеслига" -> CountryEnum.GERMANY.name
            else -> country
        }

}

data class TeamList(
    @SerializedName("1")
    private val team1: Team?,
    @SerializedName("2")
    private val team2: Team?,
    @SerializedName("3")
    private val team3: Team?,
    @SerializedName("4")
    private val team4: Team?,
    @SerializedName("5")
    private val team5: Team?,
    @SerializedName("6")
    private val team6: Team?,
    @SerializedName("7")
    private val team7: Team?,
    @SerializedName("8")
    private val team8: Team?,
    @SerializedName("9")
    private val team9: Team?,
    @SerializedName("10")
    private val team10: Team?,
    @SerializedName("11")
    private val team11: Team?,
    @SerializedName("12")
    private val team12: Team?,
    @SerializedName("13")
    private val team13: Team?,
    @SerializedName("14")
    private val team14: Team?,
    @SerializedName("15")
    private val team15: Team?,
    @SerializedName("16")
    private val team16: Team?,
    @SerializedName("17")
    private val team17: Team?,
    @SerializedName("18")
    private val team18: Team?,
    @SerializedName("19")
    private val team19: Team?,
    @SerializedName("20")
    private val team20: Team?,
) {
    fun toList(): List<Pair<Int, Team>> = mutableListOf<Pair<Int, Team>>().also { result ->
        team1?.let { result.add(Pair(1, it)) }
        team2?.let { result.add(Pair(2, it)) }
        team3?.let { result.add(Pair(3, it)) }
        team4?.let { result.add(Pair(4, it)) }
        team5?.let { result.add(Pair(5, it)) }
        team6?.let { result.add(Pair(6, it)) }
        team7?.let { result.add(Pair(7, it)) }
        team8?.let { result.add(Pair(8, it)) }
        team9?.let { result.add(Pair(9, it)) }
        team10?.let { result.add(Pair(10, it)) }
        team11?.let { result.add(Pair(11, it)) }
        team12?.let { result.add(Pair(12, it)) }
        team13?.let { result.add(Pair(13, it)) }
        team14?.let { result.add(Pair(14, it)) }
        team15?.let { result.add(Pair(15, it)) }
        team16?.let { result.add(Pair(16, it)) }
        team17?.let { result.add(Pair(17, it)) }
        team18?.let { result.add(Pair(18, it)) }
        team19?.let { result.add(Pair(19, it)) }
        team20?.let { result.add(Pair(20, it)) }
    }
}

data class Team(
    @SerializedName("Команда")
    val name: String,
    @SerializedName("Игры")
    val games: Int,
    @SerializedName("В")
    val won: Int,
    @SerializedName("Н")
    val draw: Int,
    @SerializedName("П")
    val lose: Int,
    @SerializedName("Мячи")
    val balls: String,
    @SerializedName("Очки")
    val score: Int,
    @SerializedName("% очков")
    val scorePercent: String,
)