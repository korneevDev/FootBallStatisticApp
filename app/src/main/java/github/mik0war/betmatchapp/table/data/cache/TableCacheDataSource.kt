package github.mik0war.betmatchapp.table.data.cache

import github.mik0war.betmatchapp.table.entityModel.TableDataModel
import javax.inject.Inject


class TableCacheDataSource @Inject constructor(
    private val tableDAO: TableDAO
) {

    suspend fun saveData(data: List<TableDataModel>){
        tableDAO.clearDB()
        data.forEach { tableDAO.saveTableData(it.toCacheModel()) }
    }

    suspend fun getData(country: String): List<TableDataModel> =
        tableDAO.getCountryData(country).map { it.toDataModel() }

}