package valdez.francisco.dingdone

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.google.android.material.bottomnavigation.BottomNavigationView
import kotlin.random.Random

class CreateHome : AppCompatActivity() {

    private lateinit var layoutFail: View
    private lateinit var layoutSucces: View
    private lateinit var textFail: TextView
    private lateinit var textSuccess: TextView
    private lateinit var toast: Toast

    override fun onCreate(savedInstanceState: Bundle?) {

        val inflate = layoutInflater
        layoutFail = inflate.inflate(R.layout.custome_toast_fail, null)
        layoutSucces = inflate.inflate(R.layout.custome_toast_success, null)
        textFail = layoutFail.findViewById(R.id.txtTextToastF)
        textSuccess = layoutSucces.findViewById(R.id.txtTextToastS)
        toast = Toast(this)

        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_create_home)

        var etHomeName : EditText = findViewById(R.id.et_homeName)
        val btnCancel: Button = findViewById(R.id.btnCancel)
        val btnCreate: Button = findViewById(R.id.btnCreate)
        val tvRandomCode: TextView = findViewById(R.id.tv_randomCode)

        val bottomNavigationView = findViewById<BottomNavigationView>(R.id.bottom_navigation)

        bottomNavigationView.itemIconTintList = null
        tvRandomCode.text = generateRandomCode()


        btnCreate.setOnClickListener {
            if (etHomeName.text.toString().isEmpty()) {

                textFail.text = "Please enter a name for the family"
                toast.duration = Toast.LENGTH_SHORT
                toast.view = layoutFail
                toast.show()
                etHomeName.setBackgroundResource(R.drawable.error_rounded_edit_text)
            } else {
                val code = tvRandomCode.text.toString()
                val intent = Intent(this, HomeCreated::class.java)
                intent.putExtra("invitationCode", code)
                startActivity(intent)
            }
        }

        btnCancel.setOnClickListener {
            startActivity(Intent(this, Configuration::class.java))
        }

        bottomNavigationView.setOnItemSelectedListener { item ->
            when (item.itemId) {
                R.id.btnNav_tasks -> {
                    startActivity(Intent(this, TasksActivity::class.java))

                    true
                }
                R.id.btnNav_config -> {
                    startActivity(Intent(this, HomeConfiguration::class.java))
                    true
                }
                R.id.btnNavGraphs -> {
                    startActivity(Intent(this, GraphsActivity::class.java))
                    true
                }
                else -> false
            }
        }
    }
    private fun generateRandomCode(): String {
        val letters = (1..3)
            .map { ('A'..'Z').random() }
            .joinToString("")
        val numbers = (1..3)
            .map { Random.nextInt(0, 9) }
            .joinToString("")
        return letters + numbers
    }
}