package com.example.firebasekotlinpushnotifications

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import com.google.firebase.auth.FirebaseAuth

class RegisterActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_register)


        val nameEditext = findViewById<EditText>(R.id.registername);
        val registerEmail = findViewById<EditText>(R.id.registeremail);
        val registerPassword = findViewById<EditText>(R.id.registerpassword)


        val registerButton = findViewById<Button>(R.id.registerActivityButton)



        registerButton.setOnClickListener {

            if (registerEmail.text.isEmpty() || registerPassword.text.isEmpty()) {

                Toast.makeText(this, "Please enter the informations", Toast.LENGTH_LONG).show()
            } else {

                val emailname = registerEmail.text.toString()

                val passwordname = registerPassword.text.toString()

                registeredUser(emailname, passwordname)


            }

        }

    }

    private fun registeredUser(emailname: String, passwordname: String) {


        FirebaseAuth.getInstance().createUserWithEmailAndPassword(emailname, passwordname)

            .addOnCompleteListener { task ->


                if (task.isSuccessful) {

                    Toast.makeText(this, "Successful", Toast.LENGTH_LONG).show()

                } else {

                    Toast.makeText(this, "Registration Failed", Toast.LENGTH_LONG).show()
                }


            }


    }

}
