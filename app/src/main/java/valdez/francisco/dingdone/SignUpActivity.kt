package valdez.francisco.dingdone

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import com.google.firebase.Firebase
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.auth

class SignUpActivity : AppCompatActivity() {
    private lateinit var auth: FirebaseAuth
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

                textFail.text = "Pleas fill all fields"
                toast.duration = Toast.LENGTH_SHORT
                toast.view = layoutFail
                toast.show()
//                Toast.makeText(this, "Please fill all fields", Toast.LENGTH_SHORT).show()

                if (name.isEmpty()) etNombre.setBackgroundResource(R.drawable.error_rounded_edit_text)
                if (email.isEmpty()) etEmail.setBackgroundResource(R.drawable.error_rounded_edit_text)
                if (password.isEmpty()) etPassword.setBackgroundResource(R.drawable.error_rounded_edit_text)
                if (confirmPassword.isEmpty()) etConfirmPassword.setBackgroundResource(R.drawable.error_rounded_edit_text)
                return@setOnClickListener
            }

            if (password != confirmPassword) {

                textFail.text = "Password do not match"
                toast.duration = Toast.LENGTH_SHORT
                toast.view = layoutFail
                toast.show()
//                Toast.makeText(this, "Passwords do not match", Toast.LENGTH_SHORT).show()
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

                    textSuccess.text = "Account created successfully!"
                    toast.duration = Toast.LENGTH_SHORT
                    toast.view = layoutSucces
                    toast.show()

//                    Toast.makeText(
//                        baseContext,
//                        "Account created successfully!",
//                        Toast.LENGTH_SHORT
//                    ).show()

                    val intent = Intent(this, LoginActivity::class.java)
                    intent.flags = Intent.FLAG_ACTIVITY_NEW_TASK or Intent.FLAG_ACTIVITY_CLEAR_TASK
                    startActivity(intent)
                    finish()

                } else {
                    Log.w("FAILURE", "createUserWithEmail:failure", task.exception)

                    textSuccess.text = "Account creation failed"
                    toast.duration = Toast.LENGTH_SHORT
                    toast.view = layoutSucces
                    toast.show()

//                    Toast.makeText(
//                        baseContext,
//                        "Authentication failed: ${task.exception?.message}",
//                        Toast.LENGTH_LONG // Use long for better readability of error
//                    ).show()
                }
            }
    }
}
