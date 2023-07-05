package github.mik0war.betmatchapp.table.data.cache

import androidx.room.Database
import androidx.room.RoomDatabase

@Database(
    entities = [TableCacheModel::class],
    version = 1,
)
abstract class TableDataBase : RoomDatabase(){
    abstract fun tableDao(): TableDAO
}