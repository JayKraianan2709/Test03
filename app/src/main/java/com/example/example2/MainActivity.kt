package com.example.example2

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.FirebaseUser
import kotlin.math.sign

class MainActivity : AppCompatActivity() {
    lateinit var txtid:EditText
    lateinit var txtPassword:EditText
    lateinit var buttonLogin:Button
    lateinit var buttonRegister:Button
    lateinit var iduserlogin:String
    lateinit var passwordlogin:String

    private var mAuth: FirebaseAuth? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        txtid = findViewById<EditText>(R.id.id)
        txtPassword = findViewById<EditText>(R.id.password)
        buttonLogin = findViewById<Button>(R.id.enter)
        buttonRegister = findViewById<Button>(R.id.register)

        mAuth = FirebaseAuth.getInstance()




        buttonRegister!!.setOnClickListener{
            val intern = Intent(this,register::class.java)
            startActivity(intern)
        }

        buttonLogin!!.setOnClickListener{
            sign()
    }
    }

    private fun sign() {
        iduserlogin = txtid!!.text.toString()
        passwordlogin = txtPassword.text.toString()

        mAuth!!.signInWithEmailAndPassword(iduserlogin,passwordlogin).addOnCompleteListener(this){
                task -> if (task.isSuccessful){
            Log.d("Myapp","Create New User Success!")
            val user = mAuth!!.currentUser
            updateUI(user)
        }
        else{
            Log.w("Myapp","Fail process", task.exception)
            Toast.makeText(this@MainActivity,"Asythentication Failed", Toast.LENGTH_SHORT).show()
            updateUI(null)
        }
        }


    }

    private fun updateUI(user: FirebaseUser?) {
        if (user != null){
            val uid = user.uid
            val email = user.email
            Toast.makeText(this@MainActivity,"welcome : $email your ID is : $uid", Toast.LENGTH_SHORT).show()
            val  intentSession = Intent(this,Menu::class.java )
            startActivity(intentSession)
        }
    }
}