package github.mik0war.betmatchapp.news.presentation

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.RecyclerView
import github.mik0war.betmatchapp.R
import github.mik0war.betmatchapp.core.PicassoImageLoader
import github.mik0war.betmatchapp.news.data.NewsRepository
import github.mik0war.betmatchapp.news.data.cloud.NewsCloudDataSource
import github.mik0war.betmatchapp.news.data.cloud.NewsService
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class NewsFragment: Fragment(R.layout.news_fragment) {

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        val retrofit = Retrofit.Builder()
            .baseUrl("http://84.38.181.162/api/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()
        val vm = NewsViewModel(
            NewsRepository(
                NewsCloudDataSource(
                    retrofit.create(NewsService::class.java)
                )
            ),
            NewsLiveData()
        )

        val adapter = NewsListAdapter(vm, PicassoImageLoader())

        vm.observe(this){
            adapter.update()
        }
        view.findViewById<RecyclerView>(R.id.recycler_view).adapter = adapter

        vm.loadNews()
    }
}