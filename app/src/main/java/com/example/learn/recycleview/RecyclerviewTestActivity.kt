package com.example.learn.recycleview

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.learn.bean.Food
import com.example.learn.R

class RecyclerviewTestActivity : AppCompatActivity() {
    /*
    * https://blog.csdn.net/meixi_android/article/details/90671095
    *
    * */

    companion object {
        fun actionStart(context: Context, data1: String, data2: String) {
            val intent = Intent(context, RecyclerviewTestActivity::class.java)
            intent.putExtra("param1", data1)
            intent.putExtra("param2", data2)
            context.startActivity(intent)
        }
    }


    val foodList = ArrayList<Food>()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_recyclerview_test)
        init()
        val recyclerView = findViewById<RecyclerView>(R.id.recyclerView)
        val layoutManager = LinearLayoutManager(this)
        recyclerView.layoutManager = layoutManager
        val adapter = MyRecyclerviewAdapter(foodList)
        adapter.setOnItemClickListener(object : MyRecyclerviewAdapter.onItemClickListener {
            override fun onItemClick(view: View, position: Int) {
                TODO("Not yet implemented")
                //处理业务
            }

        })
        recyclerView.adapter = MyRecyclerviewAdapter(foodList)

    }

    private fun init() {
        repeat(2) {
            foodList.add(Food("苹果", 3.3))
            foodList.add(Food("香蕉", 2.3))
            foodList.add(Food("西瓜", 1.3))
            foodList.add(Food("葡萄", 5.3))
            foodList.add(Food("西红柿", 6.3))
            foodList.add(Food("哈密瓜", 6.3))
        }
    }
}