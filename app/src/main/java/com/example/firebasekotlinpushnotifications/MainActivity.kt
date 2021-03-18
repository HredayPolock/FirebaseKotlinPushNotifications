package com.example.firebasekotlinpushnotifications

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import com.google.firebase.auth.FirebaseAuth

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val loginButton = findViewById<Button>(R.id.loginButton)


        val emailName = findViewById<EditText>(R.id.loginname)
        val passwordName = findViewById<EditText>(R.id.loginpassword)


     loginButton.setOnClickListener {
            if (emailName.text.isEmpty() || passwordName.text.isEmpty()) {

                Toast.makeText(this, "Please enter required  informations", Toast.LENGTH_LONG).show()
            } else {

                val email = emailName.text.toString()

                val password = passwordName.text.toString()

                loginUser(email, password)


            }


         val registerButton=findViewById<Button>(R.id.signupButton)
            registerButton.setOnClickListener {
                startActivity(Intent(this,RegisterActivity::class.java))

            //    startActivity(intent)


            }
        }

    }


    private fun loginUser(email: String, password: String) {


        FirebaseAuth.getInstance().signInWithEmailAndPassword(email, password)

            .addOnCompleteListener { task ->


                if (task.isSuccessful) {

                    Toast.makeText(this, "Successful", Toast.LENGTH_LONG).show()

                } else {

                    Toast.makeText(this, "Login Failed", Toast.LENGTH_LONG).show()
                }


            }

 }

}
