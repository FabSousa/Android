package com.example.checkpoint1

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.EditText
import android.widget.TextView

class MainActivity : AppCompatActivity() {

    var user = findViewById<EditText>(R.id.User).text.toString()
    var password = findViewById<EditText>(R.id.Password).text.toString()
    var result = findViewById<TextView>(R.id.Result).text

    val logins: Map<String, String> = mapOf("User1" to "Password1", "User2" to "Password2", "User3" to "Password3",
        "User4" to "Password4", "User5" to "Password5", )

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    fun login(view: View){
        if(logins[user].equals(password)){
            result = "Login efetuado"
        }else {
            result = "Usuário Não Existente"
        }
    }

    fun clear(view: View){
        user = ""
        password = ""
        result = "Resultado"
    }

}