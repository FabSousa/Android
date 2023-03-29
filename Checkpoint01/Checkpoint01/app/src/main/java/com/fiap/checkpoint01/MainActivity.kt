package com.fiap.checkpoint01

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.EditText
import android.widget.TextView

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    fun login(view: View){
        var user = findViewById<EditText>(R.id.User).text.toString()
        var password = findViewById<EditText>(R.id.Password).text.toString()
        var result = findViewById<TextView>(R.id.Result)
        val logins: Map<String, String> = mapOf("User1" to "Password1", "User2" to "Password2", "User3" to "Password3",
            "User4" to "Password4", "User5" to "Password5")

        if(logins[user].equals(password)){
            result.setText("Login efetuado")
        }else {
            result.setText("Usuário Não Existente")
        }
    }

    fun clear(view: View){
        var user = findViewById<EditText>(R.id.User)
        var password = findViewById<EditText>(R.id.Password)
        var result = findViewById<TextView>(R.id.Result)

        user.setText("")
        password.setText("")
        result.text = ""
    }

}