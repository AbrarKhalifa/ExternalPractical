package com.abrarkhalifa.external

import android.content.Intent
import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

            var sp : SharedPreferences = getSharedPreferences("MyPref", MODE_PRIVATE)
            var st = sp.getString("UserName","tt")

            Handler().postDelayed({
                if(st.equals("tt"))
                {
                    var intent = Intent(this,login_page::class.java)
                    startActivity(intent)
                    finish()
                }
                else
                {
                    var intent = Intent(this,home_page::class.java)
                    startActivity(intent)
                    finish()
                }
            },5000)
        }
    }
