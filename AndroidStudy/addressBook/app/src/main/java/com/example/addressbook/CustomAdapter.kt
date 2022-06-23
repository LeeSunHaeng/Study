package com.example.favouritelist

import android.content.Context
import android.net.Uri
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.addressbook.AddressDto
import com.example.addressbook.R

//import com.bumptech.glide.Glide


class CustomAdapter(private val context:Context, private val dataList: MutableList<AddressDto>) : RecyclerView.Adapter<ItemViewHolder>(){

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
    private val adName = itemView.findViewById<TextView>(R.id.nameTextView)
    private val adAge = itemView.findViewById<TextView>(R.id.ageTextView)
    private val adRelative = itemView.findViewById<TextView>(R.id.relativeTextView)
    private val adJob = itemView.findViewById<TextView>(R.id.jobTextView)
    private val adAddress = itemView.findViewById<TextView>(R.id.addressTextView)
    private val adphoneNumber = itemView.findViewById<TextView>(R.id.phoneNumTextView)


    // data -> resource (binding)
    fun bind(dataAc: AddressDto, context: Context){

        adName.text = dataAc.name
        adAge.text = dataAc.age.toString()
        adRelative.text = dataAc.relation
        adJob.text = dataAc.job
        adAddress.text = dataAc.address
        adphoneNumber.text = dataAc.phoneNumber




    }
}









