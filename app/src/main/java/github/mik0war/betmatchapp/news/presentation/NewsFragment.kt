package github.mik0war.betmatchapp.news.presentation

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.RecyclerView
import github.mik0war.betmatchapp.R
import github.mik0war.betmatchapp.SportApp
import github.mik0war.betmatchapp.core.PicassoImageLoader
import javax.inject.Inject

class NewsFragment: Fragment(R.layout.news_fragment) {

    @Inject
    lateinit var newsViewModel: NewsViewModel
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        ((requireActivity()).application as SportApp).appComponent.inject(this)

        val adapter = NewsListAdapter(newsViewModel, PicassoImageLoader())

        newsViewModel.observe(this){
            adapter.update()
        }
        view.findViewById<RecyclerView>(R.id.recycler_view).adapter = adapter

        newsViewModel.loadNews()
    }
}