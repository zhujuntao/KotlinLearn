package com.example.learn.listview

import android.content.Context
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.TextView
import com.example.learn.bean.Food
import com.example.learn.R

class MyListAdapter(var context: Context, var list: ArrayList<Food>) : BaseAdapter() {
    override fun getView(position: Int, convertView: View?, p2: ViewGroup?): View {
        var vh: ViewHolder? = null
        var view: View? = null
        if (convertView == null) {
            view = View.inflate(context, R.layout.item_one_layout, null)
            vh = ViewHolder()
            vh.tv = view.findViewById(R.id.tv_item_title)
            view.tag = vh
        } else {
            view = convertView
//            vh = view.tag as? ViewHolder
            vh = view.tag as ViewHolder
        }
        vh?.tv?.text=list[position].title
      /*  if (vh != null) {
            vh.tv?.text = list[position].title
        }*/
        return view!!
    }

    override fun getItem(position: Int): Any {
//       return list.get(position)
        return list[position]
    }

    override fun getItemId(position: Int): Long {
        return position.toLong()
    }

    override fun getCount(): Int {
        return list.size
    }

    inner class ViewHolder {
        var tv: TextView? = null
    }
}