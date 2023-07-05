package github.mik0war.betmatchapp.di

import android.content.Context
import androidx.room.Room
import dagger.Module
import dagger.Provides
import github.mik0war.betmatchapp.table.data.cache.TableDataBase
import javax.inject.Singleton

@Module
class RoomModule {
    @Singleton
    @Provides
    fun provideRoomDB(context: Context): TableDataBase =
        Room.databaseBuilder(
            context,
            TableDataBase::class.java, "database-countryTeams"
        ).build()

    @Singleton
    @Provides
    fun provideTableDAO(db: TableDataBase) = db.tableDao()
}