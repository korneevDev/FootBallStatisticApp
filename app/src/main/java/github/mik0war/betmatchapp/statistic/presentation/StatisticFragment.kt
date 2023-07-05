package github.mik0war.betmatchapp.statistic.presentation

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.RecyclerView
import github.mik0war.betmatchapp.R
import github.mik0war.betmatchapp.SportApp
import github.mik0war.betmatchapp.core.ColorGetter
import github.mik0war.betmatchapp.core.ColorProvider
import javax.inject.Inject

class StatisticFragment : Fragment(R.layout.statistic_fragment) {

    @Inject
    lateinit var statisticViewModel: StatisticViewModel
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        (requireActivity().application as SportApp).appComponent.inject(this)

        val attackListener: () -> Unit = {
            statisticViewModel.loadAttackData()
        }
        val defenceListener: () -> Unit = {
            statisticViewModel.loadDefenceData()
        }

        view.findViewById<StatisticTabView>(R.id.tab_buttons).setUp(attackListener, defenceListener)

        val adapter = StatisticAdapter(statisticViewModel, ColorGetter(ColorProvider(requireContext())))

        statisticViewModel.observe(this) {
            adapter.update()
        }

        view.findViewById<RecyclerView>(R.id.recycler_view).adapter = adapter
    }
}