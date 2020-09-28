package com.example.hw3

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_front_page.*
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.activity_main.btn_task0
import kotlinx.android.synthetic.main.activity_main.myToolbar

class FrontPage : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_front_page)

        setSupportActionBar(myToolbar)
        val appBar = supportActionBar
        appBar!!.title = "Task0"
        supportActionBar?.setDisplayHomeAsUpEnabled(true)

        btn_task0.setOnClickListener{
            val task0Page :FrontPageFragment = FrontPageFragment.newInstance("FrontPageFragment","Blank")
            supportFragmentManager.beginTransaction().replace(R.id.task0,task0Page,"Master").commit()
        }
    }

}