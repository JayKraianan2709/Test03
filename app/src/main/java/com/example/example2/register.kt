package com.example.example2

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.FirebaseUser

class register : AppCompatActivity() {
    lateinit var txtidregister: EditText
    lateinit var txtpasswordregister:EditText
    lateinit var buttonregister:Button
    lateinit var iduser:String
    lateinit var password:String

    private var mAuth: FirebaseAuth? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.register)
        txtidregister = findViewById<EditText>(R.id.idre)
        txtpasswordregister = findViewById<EditText>(R.id.passwordre)
        buttonregister = findViewById<Button>(R.id.butonregister)

        mAuth = FirebaseAuth.getInstance()
        buttonregister!!.setOnClickListener{
            createAccount()
        }

    }

    private fun createAccount() {
        iduser = txtidregister!!.text.toString()
        password = txtpasswordregister!!.text.toString()
        mAuth!!.createUserWithEmailAndPassword(iduser,password).addOnCompleteListener(this){
            task -> if (task.isSuccessful){
                Log.d("Myapp","Create New User Success!")
            val user = mAuth!!.currentUser
            updateUI(user)
        }
            else{
                Log.w("Myapp","Fail process", task.exception)
            Toast.makeText(this@register,"Asythentication Failed", Toast.LENGTH_SHORT).show()
            updateUI(null)
            }
        }

    }

    private fun updateUI(user: FirebaseUser?) {
        if (user != null){
            return
        }
    }
}