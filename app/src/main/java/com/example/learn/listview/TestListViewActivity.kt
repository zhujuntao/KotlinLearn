package com.example.learn.listview

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ListView
import android.widget.Toast
import com.example.learn.bean.Food
import com.example.learn.R

class TestListViewActivity : AppCompatActivity() {

    var listView: ListView? = null
    var list: ArrayList<Food>? = ArrayList()


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_test_list_view)
        init()
        listView = findViewById(R.id.list_view)
        listView?.adapter = MyListAdapter(this, list!!)
//        listView?.setOnItemClickListener(AdapterView.OnItemClickListener { adapterView, view, i, l ->  })
        listView?.setOnItemClickListener { parent, view, position, id ->
            val food= list!![position]
            Toast.makeText(this,food.title,Toast.LENGTH_LONG).show()
        }
        /*
        * 没有用到的参数可以使用—— 代替
        * */
        listView?.setOnItemClickListener { _, _, position, _ ->
            val food= list!![position]
            Toast.makeText(this,food.title,Toast.LENGTH_LONG).show()
        }
    }

    private fun init() {
        var price: Double = 0.5
        for (i in 1..10) {
            list?.add(Food("item: $i", i * price))
        }
    }
}