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

//import com.bumptech.glide.Glide


class CustomAdapter(private val context:Context, private val dataList: MutableList<Favourite>) : RecyclerView.Adapter<ItemViewHolder>(){

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
    private val fvSeq = itemView.findViewById<TextView>(R.id.item_seqText)
    private val fvImageView = itemView.findViewById<ImageView>(R.id.item_imageView)
    private val fvContent = itemView.findViewById<TextView>(R.id.item_contentText)
    private val fvDate = itemView.findViewById<TextView>(R.id.item_dateText)


    // data -> resource (binding)
    fun bind(dataAc: Favourite, context: Context){
        if(dataAc.imagePath != ""){
            val resourceId = context.resources.getIdentifier(dataAc.imagePath, "drawable", context.packageName)

            if(resourceId > 0){
                fvImageView.setImageResource(resourceId)
            }else{
                Glide.with(itemView).load(dataAc.imagePath).into(fvImageView)
            }
        } else{
            fvImageView.setImageResource(R.mipmap.ic_launcher_round) // 이미지 없다. 아무 이미지나 뿌린다
        }
        fvSeq.text = dataAc.seq.toString()

        fvContent.text = dataAc.content
        fvDate.text = dataAc.date




    }
}









