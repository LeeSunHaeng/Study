package com.example.membersprrestful

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import org.w3c.dom.Text

class CustomAdapter(val context: Context, val dataList:ArrayList<MemberDto>):RecyclerView.Adapter<CustomAdapter.ItemViewHolder>() {

   inner class ItemViewHolder(itemView: View) :RecyclerView.ViewHolder(itemView){

       val userId = itemView.findViewById<TextView>(R.id.id_textView)
       val userName = itemView.findViewById<TextView>(R.id.name_textView)
       val userEmail = itemView.findViewById<TextView>(R.id.email_textView)

       fun bind(dataVo:MemberDto,context: Context){

           userId.text=dataVo.id
           userName.text = dataVo.name
           userEmail.text = dataVo.email

           // 이동

       }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ItemViewHolder {
        val view =LayoutInflater.from(context).inflate(R.layout.view_item_layout,parent,false)
        return ItemViewHolder(view)
    }

    override fun onBindViewHolder(holder: ItemViewHolder, position: Int) {
        holder.bind(dataList[position],context)
    }

    override fun getItemCount(): Int {
        return dataList.size
    }

}