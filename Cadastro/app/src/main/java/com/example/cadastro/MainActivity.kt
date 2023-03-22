package com.example.cadastro

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText

class MainActivity : AppCompatActivity() {

    var users: MutableList<String> = mutableListOf("user1", "user2")
    var emails: MutableList<String> = mutableListOf("email1", "email2")
    var passwords: MutableList<String> = mutableListOf("passowerd1", "passowerd12")

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val btn = findViewById<Button>(R.id.signupbtn)
        btn.setOnClickListener {
            val user = findViewById<EditText>(R.id.username)
            val userInput = user.text.toString()

            var result = "User successfully registred"
            val bundle = Bundle()

            if(userInput in users){
                result = "User already registered. Insert the passowrd"
            }else if(userInput.isEmpty() || userInput.equals("")){
                result = "User empty. Type a valid user"
            }else{
                val email = findViewById<EditText>(R.id.email)
                val emailInput = email.text.toString()

                val password = findViewById<EditText>(R.id.password)
                val passwordInput = password.text.toString()

                val repassword = findViewById<EditText>(R.id.repassword)
                val repasswordInput = repassword.text.toString()

                if(passwordInput.equals(repasswordInput)){
                    users.add(userInput)
                    emails.add(emailInput)
                    passwords.add((passwordInput))
                }else{
                    result = "Password does not match. Retype the passowrd"
                }

            }

            bundle.putString("res", result)
            val intent = Intent(this, ResultActivity::class.java)
            intent.putExtras(bundle)
            startActivity(intent)

        }

    }
}