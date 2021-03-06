package com.abrarkhalifa.external

import android.content.Intent
import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_login_page.*

class login_page : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login_page)

            txtRegister.setOnClickListener {
                var intent = Intent(this,register::class.java)
                startActivity(intent)
            }
            btnLogin.setOnClickListener {
                var db = DBHelper(this)
                var arr = ArrayList<User>()
                arr = db.getUser(edtUname.text.toString())

                if(arr.size<0)
                    Toast.makeText(this,"User Doesn't Exist or Incorrect Email",Toast.LENGTH_LONG).show()
                else
                {
                    if(edtUname.text.toString().equals("") || edtpass.text.toString().equals("") )
                    {
                        Toast.makeText(this,"Fill Data Accurately",Toast.LENGTH_LONG).show()
                    }
                    else if((edtUname.text.toString().equals(arr[0].email)) && (edtpass.text.toString().equals(arr[0].password)))
                    {
                        var sp: SharedPreferences = getSharedPreferences("MyPref", MODE_PRIVATE)
                        var prefedit = sp.edit()
                        prefedit.putString("UserName",edtUname.text.toString())
                        prefedit.commit()
                        var intent = Intent(this,home_page::class.java)
                        startActivity(intent)
                    }
                    else
                        Toast.makeText(this,"Incorrect Password",Toast.LENGTH_LONG).show()
                }
            }
        }

}