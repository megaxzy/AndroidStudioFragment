package com.example.hw3

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_front_page.*
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.activity_main.btn_task0
import kotlinx.android.synthetic.main.activity_main.myToolbar

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        setSupportActionBar(myToolbar)
        val appBar = supportActionBar
        appBar!!.title = "HW3"


        btn_task0.setOnClickListener {
            val intent = Intent(this, FrontPage::class.java).apply {}
            startActivity(intent)

        }
    }
}