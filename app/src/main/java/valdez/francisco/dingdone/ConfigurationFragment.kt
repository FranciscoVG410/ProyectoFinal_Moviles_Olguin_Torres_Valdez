package valdez.francisco.dingdone

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.fragment.app.Fragment
import com.google.android.material.bottomnavigation.BottomNavigationView

class ConfigurationFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.activity_configuration, container, false)

        val btnCreateHome : Button = view.findViewById(R.id.btnCreateHome)
        val btnJoinHome : Button = view.findViewById(R.id.btnJoinHome)

        btnCreateHome.setOnClickListener{
            startActivity(Intent(requireContext(), CreateHome::class.java))
        }

        btnJoinHome.setOnClickListener {
            startActivity(Intent(requireContext(), JoinHome::class.java))
        }

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
                R.id.btnNavGraphs -> {
                    parentFragmentManager.beginTransaction()
                        .replace(R.id.fragment_container, GraphsFragment())
                        .commit()
                    true
                }
                R.id.btnNav_config -> true
                else -> false
            }
        }

        return view
    }
}