package github.mik0war.betmatchapp.table.presentation

import android.os.Bundle
import android.view.View
import android.widget.Button
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import github.mik0war.betmatchapp.R
import github.mik0war.betmatchapp.table.core.CountryEnum

class CountryFragment : Fragment(R.layout.table_country_fragment) {
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        (requireParentFragment().requireParentFragment() as TableFragment).changeTitle(
            requireContext().getString(R.string.table_country_label)
        )
        view.findViewById<Button>(R.id.button_russia).setOnClickListener {
            navigateToList(R.string.country_name_russia, CountryEnum.RUSSIA.name)
        }

        view.findViewById<Button>(R.id.button_england).setOnClickListener {
            navigateToList(R.string.country_name_england, CountryEnum.ENGLAND.name)
        }

        view.findViewById<Button>(R.id.button_germany).setOnClickListener {
            navigateToList(R.string.country_name_germany, CountryEnum.GERMANY.name)
        }

        view.findViewById<Button>(R.id.button_spain).setOnClickListener {
            navigateToList(R.string.country_name_spain, CountryEnum.SPAIN.name)
        }
    }

    private fun navigateToList(countryTitleId: Int, country: String) {
        (requireParentFragment().requireParentFragment() as TableFragment)
            .changeTitle(requireContext().getString(countryTitleId))

        findNavController().navigate(
            R.id.action_table_countryFragment_to_listFragment,
            Bundle().also { it.putString(BUNDLE_KEY, country) })
    }


    companion object {
        const val BUNDLE_KEY = "COUNTRY"
    }
}