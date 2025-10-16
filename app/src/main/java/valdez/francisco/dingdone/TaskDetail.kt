package valdez.francisco.dingdone

import android.content.Intent
import android.os.Bundle
import android.view.ViewGroup
import android.widget.Button
import android.widget.LinearLayout
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.view.ContextThemeWrapper
import androidx.core.content.ContextCompat
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.google.android.material.chip.Chip
import com.google.android.material.chip.ChipGroup

class TaskDetail : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_task_detail)


        val nombre = intent.getStringExtra("nombre")
        val descripcion = intent.getStringExtra("descripcion")
        val estado = intent.getStringExtra("estado")
        val miembros = intent.getStringArrayListExtra("miembros") ?: arrayListOf()

        val tvNombre : TextView = findViewById(R.id.tvTituloDetail)
        val tvDescripcion : TextView = findViewById(R.id.tvDescripcionDetal)
        val btnChangeState : Button = findViewById(R.id.btnChangeState)
        val chgMiembros : ChipGroup = findViewById(R.id.chgMembersTaskDetal)
        val btnReturn : Button = findViewById(R.id.btnBackHome)

        btnChangeState.text = estado
        if(btnChangeState.text == "Completada"){

            btnChangeState.setBackgroundResource(R.drawable.item_completed)

        }else if (btnChangeState.text == "Pendiente"){

            btnChangeState.setBackgroundResource(R.drawable.item_pending)

        }
        tvNombre.text = nombre
        tvDescripcion.text = descripcion
        btnChangeState.setOnClickListener{

            if(btnChangeState.text == "Completada"){

                btnChangeState.text = "Pendiente"
                btnChangeState.setBackgroundResource(R.drawable.item_pending)

            }else if (btnChangeState.text == "Pendiente"){

                btnChangeState.text = "Completada"
                btnChangeState.setBackgroundResource(R.drawable.item_completed)

            }

        }

        btnReturn.setOnClickListener{

            startActivity(Intent(this, TasksActivity::class.java))

        }

        chgMiembros.removeAllViews()

        miembros.forEach{ member: String ->

            val chipContext = ContextThemeWrapper(chgMiembros.context, com.google.android.material.R.style.Theme_MaterialComponents_Light)
            val chip = Chip(chipContext).apply {

                text = member
                isClickable = false
                isCheckable = false
                setChipBackgroundColorResource(R.color.btnBackground)
                setTextColor(ContextCompat.getColor(chgMiembros.context, R.color.white))

                isCloseIconVisible = true

            }

            chgMiembros.addView(chip)

        }


    }
//    private fun addChip(name: String) {
//        val chip = TextView(this).apply {  // aquí usas 'this' en lugar de 'requireContext()'
//            text = "$name ✕"
//            setPadding(24, 8, 24, 8)
//            setTextColor(ContextCompat.getColor(this@TaskDetail, R.color.white))
//            background = ContextCompat.getDrawable(this@TaskDetail, R.drawable.button_enabled)
//            setOnClickListener { chipsContainer.removeView(this) }
//
//            val params = LinearLayout.LayoutParams(
//                ViewGroup.LayoutParams.WRAP_CONTENT,
//                ViewGroup.LayoutParams.WRAP_CONTENT
//            )
//            params.setMargins(8, 0, 8, 0)
//            layoutParams = params
//        }
//        chipsContainer.addView(chip)
//    }

}

