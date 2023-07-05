package github.mik0war.betmatchapp.table.data

import github.mik0war.betmatchapp.table.data.cache.TableCacheDataSource
import github.mik0war.betmatchapp.table.data.cloud.TableCloudDataSource
import github.mik0war.betmatchapp.table.entityModel.TableDataModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class TableRepository(
    private val cloudDataSource: TableCloudDataSource,
    private val cacheDataSource: TableCacheDataSource
) {

    suspend fun loadData() = withContext(Dispatchers.IO){
        cacheDataSource.saveData(cloudDataSource.loadData())
    }

    suspend fun getData(country: String): List<TableDataModel> = withContext(Dispatchers.IO){
        return@withContext cacheDataSource.getData(country)
    }
}