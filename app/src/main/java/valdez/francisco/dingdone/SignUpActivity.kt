package valdez.francisco.dingdone

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.google.firebase.Firebase
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.auth

class SignUpActivity : AppCompatActivity() {
    private lateinit var auth: FirebaseAuth

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_sign_up)

        auth = Firebase.auth

        val etNombre: EditText = findViewById(R.id.etRName)
        val etEmail: EditText = findViewById(R.id.etREmail)
        val etPassword: EditText = findViewById(R.id.etRPassword)
        val etConfirmPassword: EditText = findViewById(R.id.etRConfirmPassword)

        val btnCreateAccount: Button = findViewById(R.id.btnCreateAccount)
        val btnBackLogin: Button = findViewById(R.id.btnBackLogin)

        btnCreateAccount.setOnClickListener {
            val name = etNombre.text.toString()
            val email = etEmail.text.toString()
            val password = etPassword.text.toString()
            val confirmPassword = etConfirmPassword.text.toString()

            etNombre.setBackgroundResource(R.drawable.rounded_edit_text)
            etEmail.setBackgroundResource(R.drawable.rounded_edit_text)
            etPassword.setBackgroundResource(R.drawable.rounded_edit_text)
            etConfirmPassword.setBackgroundResource(R.drawable.rounded_edit_text)

            if (name.isEmpty() || email.isEmpty() || password.isEmpty() || confirmPassword.isEmpty()) {
                Toast.makeText(this, "Please fill all fields", Toast.LENGTH_SHORT).show()

                if (name.isEmpty()) etNombre.setBackgroundResource(R.drawable.error_rounded_edit_text)
                if (email.isEmpty()) etEmail.setBackgroundResource(R.drawable.error_rounded_edit_text)
                if (password.isEmpty()) etPassword.setBackgroundResource(R.drawable.error_rounded_edit_text)
                if (confirmPassword.isEmpty()) etConfirmPassword.setBackgroundResource(R.drawable.error_rounded_edit_text)
                return@setOnClickListener
            }

            if (password != confirmPassword) {
                Toast.makeText(this, "Passwords do not match", Toast.LENGTH_SHORT).show()
                etPassword.setBackgroundResource(R.drawable.error_rounded_edit_text)
                etConfirmPassword.setBackgroundResource(R.drawable.error_rounded_edit_text)
                return@setOnClickListener
            }

            signIn(email, password)
        }

        btnBackLogin.setOnClickListener {
            startActivity(Intent(this, LoginActivity::class.java))
        }
    }

    private fun signIn(email: String, password: String) {
        Log.d("INFO", "email: $email, password: $password")
        auth.createUserWithEmailAndPassword(email, password)
            .addOnCompleteListener(this) { task ->
                if (task.isSuccessful) {
                    Log.d("SUCCESS", "createUserWithEmail:success")
                    Toast.makeText(
                        baseContext,
                        "Account created successfully!",
                        Toast.LENGTH_SHORT
                    ).show()

                    val intent = Intent(this, MainActivity::class.java)
                    intent.flags = Intent.FLAG_ACTIVITY_NEW_TASK or Intent.FLAG_ACTIVITY_CLEAR_TASK
                    startActivity(intent)
                    finish()

                } else {
                    Log.w("FAILURE", "createUserWithEmail:failure", task.exception)
                    Toast.makeText(
                        baseContext,
                        "Authentication failed: ${task.exception?.message}",
                        Toast.LENGTH_LONG // Use long for better readability of error
                    ).show()
                }
            }
    }
}
