package com.example.ex21

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.CheckBox
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast

class MainActivity : AppCompatActivity() {
    private lateinit var username: EditText
    private lateinit var password: EditText
    private lateinit var keepSignIn: CheckBox
    private lateinit var resetPassword: TextView
    private lateinit var signInBtn: Button
    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        username = findViewById(R.id.usernameInput)
        password = findViewById(R.id.passwordInput)
        keepSignIn = findViewById(R.id.keepSignInBtn)
        resetPassword = findViewById(R.id.resetBtn)
        signInBtn = findViewById(R.id.signinBtn)

        signInBtn.setOnClickListener { handleSignIn() }
        resetPassword.setOnClickListener { handleReset() }
    }

    private fun handleSignIn() {
        if (username.text.toString() == "admin" && password.text.toString() == "admin1234") {
            return makeToast("Đăng nhập thành công")
        }
        if (username.text.isEmpty() || password.text.isEmpty()) {
            return makeToast("Vui lòng nhập username/pasword")
        }
        val regex = "^(?=.*[a-z])(?=.*[A-Z]).{6,}\$".toRegex()
        if (regex.matches(password.text.toString())) {
            return makeToast("Mật khẩu không đúng yêu cầu")
        }
    }

    private fun handleReset() {
        if (username.text.isEmpty()) {
            return makeToast("Vui lòng nhập username")
        }
        if (username.text.toString() == "admin") {
            return makeToast("Reset mật khẩu thành công")
        }
    }

    private fun makeToast(content: String) {
        return Toast.makeText(applicationContext, content, Toast.LENGTH_SHORT).show()
    }

}