package github.mik0war.betmatchapp.table.presentation

import android.os.Bundle
import android.view.View
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.room.Room
import github.mik0war.betmatchapp.R
import github.mik0war.betmatchapp.table.data.TableRepository
import github.mik0war.betmatchapp.table.data.cache.TableCacheDataSource
import github.mik0war.betmatchapp.table.data.cache.TableDataBase
import github.mik0war.betmatchapp.table.data.cloud.TableCloudDataSource
import github.mik0war.betmatchapp.table.data.cloud.TableDataService
import github.mik0war.betmatchapp.table.domain.GetDataUseCase
import github.mik0war.betmatchapp.table.domain.LoadDataUseCase
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class TableFragment : Fragment(R.layout.table_fragment) {

    lateinit var viewModel: TableViewModel
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        val retrofit = Retrofit.Builder()
            .baseUrl("http://84.38.181.162/api/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()

        val db = Room.databaseBuilder(
            requireContext(),
            TableDataBase::class.java, "database-countryTeams"
        ).build()
        val repo = TableRepository(
            TableCloudDataSource(
                retrofit.create(TableDataService::class.java)
            ),
            TableCacheDataSource(
                db.tableDao()
            )
        )
        viewModel = TableViewModel(
            GetDataUseCase(
                repo
            ),
            LoadDataUseCase(
                repo
            ),
            TableLiveData()
        )

        viewModel.loadData()
    }

    fun changeTitle(title: String) {
        view?.let { it.findViewById<TextView>(R.id.tableLabel).text = title }
    }
}