package valdez.francisco.dingdone

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.google.android.material.bottomnavigation.BottomNavigationView

class GraphsFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.activity_graphs, container, false)

        val bottomNavigationView = view.findViewById<BottomNavigationView>(R.id.bottom_navigation)

        bottomNavigationView.itemIconTintList = null

        bottomNavigationView.setOnItemSelectedListener { item ->
            when (item.itemId) {
                R.id.btnNav_tasks -> {
                    parentFragmentManager.beginTransaction()
                        .replace(R.id.fragment_container, TasksFragment())
                        .commit()
                    true
                }
                R.id.btnNavGraphs -> true
                R.id.btnNav_config -> {
                    // Replace with ConfigurationFragment when created
                    startActivity(Intent(requireContext(), Configuration::class.java))
                    requireActivity().overridePendingTransition(0, 0)
                    true
                }
                else -> false
            }
        }

        return view
    }
}