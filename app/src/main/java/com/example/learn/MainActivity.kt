package com.example.learn

import android.content.Intent
import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import com.example.learn.recycleview.RecyclerviewTestActivity

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        findViewById<View>(R.id.tv_jump).setOnClickListener { //                startActivity(new Intent(MainActivity.this,TestListViewActivity.class));
            startActivity(Intent(this@MainActivity, RecyclerviewTestActivity::class.java))
        }
    }
}