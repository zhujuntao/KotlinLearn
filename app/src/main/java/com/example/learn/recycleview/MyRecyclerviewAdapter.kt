package com.example.learn.recycleview

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import com.example.learn.bean.Food
import com.example.learn.R

class MyRecyclerviewAdapter(var list: List<Food>) : RecyclerView.Adapter<MyRecyclerviewAdapter.ViewHolder>() {
    private var mOnItemClickListener: onItemClickListener? = null

    inner class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val title: TextView = view.findViewById(R.id.tv_item_title)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_one_layout, parent, false)
        val viewHolder = ViewHolder(view)
        viewHolder.itemView.setOnClickListener {
            val position = viewHolder.adapterPosition
            val food = list[position]
            Toast.makeText(parent.context, food.title, Toast.LENGTH_LONG).show()
        }
        return ViewHolder(view)

    }

    override fun getItemCount(): Int {
        return list.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val food = list[position]
        holder.title.text = food.title
        //判断是否设置了监听器
        if (mOnItemClickListener != null) {
            val position = holder.adapterPosition
            mOnItemClickListener!!.onItemClick(holder.itemView, position)
        }
    }

    interface onItemClickListener {
        fun onItemClick(view: View, position: Int)
    }

    fun setOnItemClickListener(onItemClickListener: onItemClickListener) {
        this.mOnItemClickListener = onItemClickListener
    }

    /* //  删除 打勾 全选
     fun cleckAll(is_checked: Int) { //全选 删除多少那里要删除全部
         for (a in entityList.indices) {
             if (is_checked == a) {
                 entityList.get(a).bname = "选中了"
             } else {

             }
         }
         notifyDataSetChanged()
     }*/
}