package com.example.kotlin_sharepreferent

import android.content.Intent
import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_home_main.*
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    // Lateinit giúp cho biến không cần phải khao báo trước
    lateinit var sharedPreferences: SharedPreferences
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // code
        sharedPreferences = getSharedPreferences("InforLogin", MODE_PRIVATE)


        bt_login.setOnClickListener {
            var Username= edt_userName.text.toString()
            var Passord = edt_passord.text.toString()


            // xét điều kiện if else cho password và username

            if (sharedPreferences != null){
                var editor = sharedPreferences.edit()


                editor.putString("userName",Username.toString())
                editor.putString("passWord",Passord.toString())

                editor.apply()

                var intent= Intent(this@MainActivity, home_main::class.java)
                startActivity(intent)
                finish()

            }
            else{
                var edtor = getSharedPreferences("InforLogin", MODE_PRIVATE).edit()

                edtor.putString("userName",Username.toString())
                edtor.putString("passWord",Passord.toString())

                edtor.apply()

                var intent= Intent(this@MainActivity, home_main::class.java)
                startActivity(intent)
                finish()

            }
        }
    }
}