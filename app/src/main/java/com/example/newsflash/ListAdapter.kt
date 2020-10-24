package com.example.newsflash

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class ListAdapter(private val listener: ItemClicked): RecyclerView.Adapter<ViewHolder>(){

    private  val items: ArrayList<News> = ArrayList()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {

        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_news,parent,false)
        val viewHolder = ViewHolder(view)
        view.setOnClickListener(){
            listener.onItemClicked(items[viewHolder.adapterPosition])
        }
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {

        val currentItem = items[position]
        holder.titleView.text = currentItem.title
//        holder.author.text = currentItem.author
//        Glide.with(holder.itemView.context).load(currentItem.imageUrl).into(holder.image)

    }

    override fun getItemCount(): Int {

        return items.size
    }

    fun updateNews(updatedNews: ArrayList<News>){
        items.clear()
        items.addAll(updatedNews)

        notifyDataSetChanged()
    }
}

class ViewHolder(itemView: View): RecyclerView.ViewHolder(itemView) {

    val titleView: TextView = itemView.findViewById(R.id.textView)
//    val image: ImageView = itemView.findViewById(R.id.image)
//    val author: TextView = itemView.findViewById(R.id.author)


}

interface ItemClicked{
    fun onItemClicked(item: News)
}