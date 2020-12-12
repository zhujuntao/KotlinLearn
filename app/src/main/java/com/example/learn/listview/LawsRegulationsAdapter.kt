package com.example.learn.listview

import android.content.Context
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.ImageView
import android.widget.TextView

class LawsRegulationsAdapter(var context: Context, var list: ArrayList<String>) : BaseAdapter() {
    override fun getView(position: Int, convertView: View?, p2: ViewGroup?): View {
        var vh: ViewHolder? = null
        var view: View? = null
        if (convertView == null) {
          /*  view = View.inflate(context, R.layout.laws_regulations_item, null)
            vh = ViewHolder()
            vh.tv = view.findViewById(R.id.tv_laws_regulations_type)
            vh.img = view.findViewById(R.id.img_laws_regulations_item)
            view.tag = vh*/
        } else {
            view = convertView
//            vh = view.tag as? ViewHolder
            vh = view.tag as ViewHolder
        }
        vh?.tv?.text = "$position 法律法规"
//        vh?.img?.loadRound(context, list[position], R.drawable.signature_ok)
        /*  if (vh != null) {
              vh.tv?.text = list[position].title
          }*/
        return view!!
    }

    override fun getItem(position: Int): Any {
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
        var img: ImageView? = null
    }
}