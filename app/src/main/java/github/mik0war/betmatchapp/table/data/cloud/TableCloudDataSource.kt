package github.mik0war.betmatchapp.table.data.cloud

import github.mik0war.betmatchapp.table.entityModel.TableDataModel
import javax.inject.Inject

class TableCloudDataSource @Inject constructor(
    private val tableDataService: TableDataService
) {
    suspend fun loadData(): List<TableDataModel> =
        mutableListOf<TableDataModel>().also{ list ->
            tableDataService.getData().map { list.addAll(it.mapToDataModelList()) }
        }
}