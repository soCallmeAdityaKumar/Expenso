package com.example.expenso

import android.content.Intent
import android.os.Bundle
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.ktx.auth
import com.google.firebase.ktx.Firebase

class registerCustomer:AppCompatActivity() {
    private lateinit var auth:FirebaseAuth
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.registercustomer)

        auth=Firebase.auth
        val email=findViewById<EditText>(R.id.EmailEditText).text.toString()
        val password=findViewById<EditText>(R.id.PasswordEditText).text.toString()

        auth.createUserWithEmailAndPassword(email,password)
            .addOnCompleteListener { task->
                if(task.isSuccessful){
                    startActivity(Intent(this,MainActivity::class.java))
                }
                else{
                    Toast.makeText(this,"Unable to Register",Toast.LENGTH_LONG).show()

                }
            }


    }


    }
