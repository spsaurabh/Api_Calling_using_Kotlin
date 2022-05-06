package com.example.api_calling

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import org.w3c.dom.Text

class MyAdapter(val context:Context, val userList:List<MyDataItem>):RecyclerView.Adapter<MyAdapter.ViewHolder>() {
    class ViewHolder(itemView:View ):RecyclerView.ViewHolder(itemView) {
        //lateinit var userId : TextView
        var t = itemView.findViewById<TextView>(R.id.title1)
        var t2 = itemView.findViewById<TextView>(R.id.userId1)

//        //lateinit var title : TextView
    //     init {
//            userId = itemView.findViewById(R.id.userId1)
//            title = itemView.findViewById(R.id.title1)
//        }
    }
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        var itemView = LayoutInflater.from(parent.context).inflate(R.layout.row_item,parent,false)
        return ViewHolder(itemView)
    }
    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
//        holder.userId.text = userList[position].userId.toString()
//        holder.title.text = userList[position].title

        holder.t.text = userList[position].title
        holder.t2.text = userList[position].userId.toString()
    }
    override fun getItemCount(): Int {
        return userList.size
    }
}