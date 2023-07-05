package github.mik0war.betmatchapp.di

import android.content.Context
import dagger.BindsInstance
import dagger.Component
import github.mik0war.betmatchapp.news.presentation.NewsFragment
import github.mik0war.betmatchapp.statistic.presentation.StatisticFragment
import github.mik0war.betmatchapp.table.presentation.TableFragment
import javax.inject.Singleton

@Singleton
@Component(
    modules = [RetrofitModule::class, RoomModule::class]
)
interface ApplicationComponent {

    @Component.Factory
    interface Factory {
        fun create(@BindsInstance context: Context): ApplicationComponent
    }

    fun inject(newsFragment: NewsFragment)
    fun inject(statisticFragment: StatisticFragment)
    fun inject(tableFragment: TableFragment)
}