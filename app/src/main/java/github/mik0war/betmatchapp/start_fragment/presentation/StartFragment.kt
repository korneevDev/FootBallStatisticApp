package github.mik0war.betmatchapp.start_fragment.presentation

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import github.mik0war.betmatchapp.R
import kotlinx.coroutines.DelicateCoroutinesApi
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

@OptIn(DelicateCoroutinesApi::class)
class StartFragment: Fragment(R.layout.start_fragment) {

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        GlobalScope.launch(Dispatchers.Main) {
            delay(3000)
            findNavController().navigate(R.id.action_startFragment_to_menuFragment)
        }
    }
}