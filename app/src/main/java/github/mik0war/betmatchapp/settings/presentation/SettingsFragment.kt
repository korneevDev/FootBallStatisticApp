package github.mik0war.betmatchapp.settings.presentation

import android.content.res.Configuration
import android.os.Bundle
import android.view.View
import android.widget.Button
import androidx.appcompat.app.AppCompatDelegate
import androidx.appcompat.widget.SwitchCompat
import androidx.fragment.app.Fragment
import github.mik0war.betmatchapp.MainActivity
import github.mik0war.betmatchapp.R

class SettingsFragment : Fragment(R.layout.settings_fragment) {

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        setUpThemeSwitch(view.findViewById(R.id.dark_theme_switch))

        view.findViewById<Button>(R.id.button_change_background)
            .setOnClickListener {
                (requireActivity() as MainActivity).changeBackGround()
            }

    }

    private fun setUpThemeSwitch(themeSwitch: SwitchCompat){
        if(resources.configuration.uiMode and
            Configuration.UI_MODE_NIGHT_MASK == Configuration.UI_MODE_NIGHT_YES)
            themeSwitch.isChecked = true

        themeSwitch.setOnCheckedChangeListener { _, isChecked ->
            when (isChecked) {
                true -> AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_YES)
                false -> AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO)
            }
        }
    }

}