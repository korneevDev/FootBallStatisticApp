package github.mik0war.betmatchapp.table.presentation

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.RecyclerView
import github.mik0war.betmatchapp.R
import github.mik0war.betmatchapp.core.ColorGetter
import github.mik0war.betmatchapp.core.ColorProvider

class ListFragment : Fragment(R.layout.table_list_fragment) {
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        val viewModel = (requireParentFragment().requireParentFragment() as TableFragment).tableViewModel

        val adapter = TableAdapter(viewModel, ColorGetter(ColorProvider(requireContext())))

        viewModel.observe(this){
            adapter.update()
        }

        view.findViewById<RecyclerView>(R.id.recycler_view).adapter = adapter

        val country = arguments?.getString(CountryFragment.BUNDLE_KEY)

        country?.let {
            viewModel.getData(it)
        }
    }
}