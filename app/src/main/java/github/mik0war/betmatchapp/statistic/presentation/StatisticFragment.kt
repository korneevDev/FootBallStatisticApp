package github.mik0war.betmatchapp.statistic.presentation

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.RecyclerView
import github.mik0war.betmatchapp.R
import github.mik0war.betmatchapp.core.ColorGetter
import github.mik0war.betmatchapp.core.ContextColorProvider
import github.mik0war.betmatchapp.statistic.attack.data.AttackRepository
import github.mik0war.betmatchapp.statistic.attack.data.cloud.AttackService
import github.mik0war.betmatchapp.statistic.attack.domain.AttackUseCase
import github.mik0war.betmatchapp.statistic.defence.data.DefenceRepository
import github.mik0war.betmatchapp.statistic.defence.data.cloud.DefenceService
import github.mik0war.betmatchapp.statistic.defence.domain.DefenceUseCase
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class StatisticFragment : Fragment(R.layout.statistic_fragment) {

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        val retrofit = Retrofit.Builder()
            .baseUrl("http://84.38.181.162/api/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()
        val vm = StatisticViewModel(
            StatisticLiveData(),
            AttackUseCase(
                AttackRepository(
                    retrofit.create(AttackService::class.java)
                )
            ),
            DefenceUseCase(
                DefenceRepository(
                    retrofit.create(DefenceService::class.java)
                )
            )
        )

        val attackListener: () -> Unit = {
            vm.loadAttackData()
        }
        val defenceListener: () -> Unit = {
            vm.loadDefenceData()
        }

        view.findViewById<StatisticTabView>(R.id.tab_buttons).setUp(attackListener, defenceListener)

        val adapter = StatisticAdapter(vm, ColorGetter(ContextColorProvider(requireContext())))

        vm.observe(this) {
            adapter.update()
        }

        view.findViewById<RecyclerView>(R.id.recycler_view).adapter = adapter
    }
}