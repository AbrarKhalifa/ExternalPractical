package com.abrarkhalifa.external

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_register.*

class register : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_register)

            txtLogin.setOnClickListener {
                var intent = Intent(this,login_page::class.java)
                startActivity(intent)
            }
            btnRegister.setOnClickListener {
                if(edtRegisterName.text.toString().equals("") || edtRegisterAge.text.toString().equals("")
                    || edtRegisterpass.text.toString().equals("") )
                {
                    Toast.makeText(this,"Fill Data Accurately",Toast.LENGTH_LONG).show()
                }
                else if(edtRegisterpass.text.toString().length<=7)
                {
                    Toast.makeText(this,"Password Must be 8 Character Long!",Toast.LENGTH_LONG).show()
                }
                else
                {
                    var us = User(edtRegisterpass.text.toString(),edtRegisterName.text.toString(),edtRegisterAge.text.toString().toInt())
                    var db = DBHelper(this)

                    var res = db.insertUser(us)
                    if(res>0)
                    {
                        Toast.makeText(this,"Register Successfully",Toast.LENGTH_LONG).show()
                        var intent = Intent(this,login_page::class.java)
                        startActivity(intent)
                        finish()
                    }
                }
            }
        }
    }
