package github.mik0war.betmatchapp.main_menu.presentation

import android.os.Bundle
import android.view.View
import android.view.View.OnClickListener
import android.widget.Button
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import github.mik0war.betmatchapp.R

class MenuFragment: Fragment(R.layout.menu_fragment), OnClickListener {

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        view.findViewById<Button>(R.id.button_table).setOnClickListener(this)
        view.findViewById<Button>(R.id.button_news).setOnClickListener(this)
        view.findViewById<Button>(R.id.button_statistic).setOnClickListener(this)
        view.findViewById<Button>(R.id.button_settings).setOnClickListener(this)
    }

    override fun onClick(p0: View?) {
        findNavController().navigate(
        when(p0?.id){
            R.id.button_table -> R.id.action_menuFragment_to_tableFragment
            R.id.button_news -> R.id.action_menuFragment_to_newsFragment
            R.id.button_statistic -> R.id.action_menuFragment_to_statisticFragment
            R.id.button_settings -> R.id.action_menuFragment_to_settingsFragment

            else -> throw IllegalStateException()
        }
        )
    }
}