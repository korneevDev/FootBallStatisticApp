package github.mik0war.betmatchapp.table.presentation

import android.os.Bundle
import android.view.View
import android.widget.TextView
import androidx.fragment.app.Fragment
import github.mik0war.betmatchapp.R
import github.mik0war.betmatchapp.SportApp
import javax.inject.Inject

class TableFragment : Fragment(R.layout.table_fragment) {

    @Inject
    lateinit var tableViewModel: TableViewModel
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        (requireActivity().application as SportApp).appComponent.inject(this)
        tableViewModel.loadData()
    }

    fun changeTitle(title: String) {
        view?.let { it.findViewById<TextView>(R.id.tableLabel).text = title }
    }
}