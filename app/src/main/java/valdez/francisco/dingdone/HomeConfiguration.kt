package valdez.francisco.dingdone

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.google.android.material.bottomnavigation.BottomNavigationView

class HomeConfiguration : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home_configuration)

        val btnConfirm :Button = findViewById(R.id.btnConfirm)
        val bottomNavigationView = findViewById<BottomNavigationView>(R.id.bottom_navigation)

        bottomNavigationView.itemIconTintList = null


        btnConfirm.setOnClickListener{
            startActivity(Intent(this, TasksActivity::class.java))
        }
        bottomNavigationView.setOnItemSelectedListener { item ->
            when (item.itemId) {
                R.id.btnNav_tasks -> {
                    startActivity(Intent(this, TasksActivity::class.java))
                    overridePendingTransition(0, 0)
                    true
                }
                R.id.btnNavGraphs ->{
                    startActivity(Intent(this, GraphsActivity::class.java))
                    overridePendingTransition(0, 0)
                    true
                }
                R.id.btnNav_config -> true // Ya estás en esta
                else -> false
            }
        }
    }
}