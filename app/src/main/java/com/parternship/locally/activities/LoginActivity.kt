package com.parternship.locally.activities

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.widget.ImageView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.bumptech.glide.Glide
import com.facebook.CallbackManager
import com.facebook.FacebookCallback
import com.facebook.FacebookException
import com.facebook.login.LoginResult
import com.facebook.login.widget.LoginButton
import com.parternship.locally.R

class LoginActivity : AppCompatActivity() {
    lateinit var callbackManager: CallbackManager

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        callbackManager = CallbackManager.Factory.create()

        val image :ImageView = findViewById(R.id.image_view)
        val loginButton = findViewById<LoginButton>(R.id.login_button)
        loginButton.setPermissions(listOf("public_profile","email"))
        loginButton.registerCallback(callbackManager,object :FacebookCallback<LoginResult?>{
            override fun onSuccess(loginResult: LoginResult?) {
                Log.d("TAG", "Success Login")
                if (loginResult != null) {
                    Glide.with(this@LoginActivity).load("https://graph.facebook.com/" + loginResult.accessToken.userId + "/picture?return_ssl_resources=1").into(image)
                }
                //loginResult.accessToken
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
}