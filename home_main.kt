package com.example.kotlin_sharepreferent

import android.content.Context
import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_home_main.*

class home_main : AppCompatActivity() {
    private lateinit var sharedPreferences: SharedPreferences

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home_main)

        var sharedPreferences = getSharedPreferences("InforLogin", MODE_PRIVATE)

        if (sharedPreferences != null) {
            var user = sharedPreferences.getString("userName", "defaul_namee")
            var pass = sharedPreferences.getString("passWord", "defaul_pass")

            txt_NameLogin.text = user
            txt_NamePass.text = pass
            Log.d("Pass in Home", pass!!)
        } else {
            Toast.makeText(this, "xxxxxxxxxxx", Toast.LENGTH_SHORT).show()
        }

        bt_logout.setOnClickListener {
            var prefs = getSharedPreferences("InfoLogin", Context.MODE_PRIVATE)
            if (prefs != null) {
                prefs.edit().clear().commit() // Xóa gói SharePref lấy được
                prefs.edit().remove("userName").commit()
                prefs.edit().remove("passWord").commit()
                // Chỉ hỗ trợ xóa key value của gói
            }
        }


    }
}
