package com.example.work7accountbookcopy

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
//import com.bumptech.glide.Glide
import com.example.work7accountbookcopy.R
import com.example.work7accountbookcopy.DataVo

class CustomAdapter(private val context:Context, private val dataList: MutableList<Account>) : RecyclerView.Adapter<ItemViewHolder>(){

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ItemViewHolder {
        val view = LayoutInflater.from(context).inflate(R.layout.view_item_layout, parent, false)
        return  ItemViewHolder(view)
    }

    override fun onBindViewHolder(holder: ItemViewHolder, position: Int) {
        holder.bind(dataList[position], context)
    }

    override fun getItemCount(): Int {
        return  dataList.size
    }
}

class ItemViewHolder(itemView:View) : RecyclerView.ViewHolder(itemView){
    private val acSeq = itemView.findViewById<TextView>(R.id.item_seqText)
    private val acTitle = itemView.findViewById<TextView>(R.id.item_titleText)
    private val acDay = itemView.findViewById<TextView>(R.id.item_dayText)
    private val acMoney = itemView.findViewById<TextView>(R.id.item_moneyText)
    private val acMemo= itemView.findViewById<TextView>(R.id.item_memoText)

    // data -> resource (binding)
    fun bind(dataAc: Account, context: Context){

        acSeq.text = dataAc.seq.toString()
        acTitle.text = dataAc.title
        acDay.text = dataAc.date
        acMoney.text = dataAc.money.toString()
        acMemo.text = dataAc.memo




    }
}









