package github.mik0war.betmatchapp.di

import dagger.Module
import dagger.Provides
import github.mik0war.betmatchapp.news.data.cloud.NewsService
import github.mik0war.betmatchapp.statistic.attack.data.cloud.AttackService
import github.mik0war.betmatchapp.statistic.defence.data.cloud.DefenceService
import github.mik0war.betmatchapp.table.data.cloud.TableDataService
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
class RetrofitModule {

    @Singleton
    @Provides
    fun provideRetrofit() = Retrofit.Builder()
        .baseUrl("http://84.38.181.162/api/")
        .addConverterFactory(GsonConverterFactory.create())
        .build()

    @Singleton
    @Provides
    fun provideNewsService(retrofit: Retrofit): NewsService =
        retrofit.create(NewsService::class.java)

    @Singleton
    @Provides
    fun provideStatisticAttackService(retrofit: Retrofit): AttackService =
        retrofit.create(AttackService::class.java)

    @Singleton
    @Provides
    fun provideStatisticDefenceService(retrofit: Retrofit): DefenceService =
        retrofit.create(DefenceService::class.java)

    @Singleton
    @Provides
    fun provideTableService(retrofit: Retrofit): TableDataService =
        retrofit.create(TableDataService::class.java)

}