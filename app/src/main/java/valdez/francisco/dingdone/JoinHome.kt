package valdez.francisco.dingdone

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity

class JoinHome : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_join_home)

        val btnJoinHome: Button = findViewById(R.id.btnCreateHome)
        val btnCancel : Button = findViewById(R.id.btnCancel)

        btnJoinHome.setOnClickListener {
            startActivity(Intent(this, TasksActivity::class.java))
        }

        btnCancel.setOnClickListener {
            startActivity(Intent(this, Configuration::class.java))
        }
    }
}