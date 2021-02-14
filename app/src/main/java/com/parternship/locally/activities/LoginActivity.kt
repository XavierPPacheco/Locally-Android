package com.parternship.locally.activities

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.widget.ImageView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.bumptech.glide.Glide
import com.facebook.*
import com.facebook.login.LoginResult
import com.facebook.login.widget.LoginButton
import com.parternship.locally.R
import org.json.JSONObject

class LoginActivity : AppCompatActivity() {
    lateinit var callbackManager: CallbackManager

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        callbackManager = CallbackManager.Factory.create()

        val loginButton = findViewById<LoginButton>(R.id.login_button)

        loginButton.setPermissions(listOf("public_profile","email"))
        loginButton.registerCallback(callbackManager,object :FacebookCallback<LoginResult?>{
            override fun onSuccess(loginResult: LoginResult?) {
                Log.d("TAG", "Success Login")
                loginSuccess()

            }

            override fun onCancel() {
                Toast.makeText(this@LoginActivity, "Login Cancelled", Toast.LENGTH_LONG).show()
            }

            override fun onError(exception: FacebookException) {
                Toast.makeText(this@LoginActivity, exception.message, Toast.LENGTH_LONG).show()
            }
        })



    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        callbackManager.onActivityResult(requestCode, resultCode, data)
        super.onActivityResult(requestCode, resultCode, data)
    }

    /**
     * This function exists to extend Google login as well
     */
    fun loginSuccess(){
        val intent  =  Intent(this@LoginActivity,MainActivity::class.java)
        startActivity(intent)
    }
}