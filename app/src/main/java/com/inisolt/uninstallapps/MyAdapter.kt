package com.inisolt.uninstallapps

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.item_recyclerview.view.*
import java.util.*

class MyAdapter(context: Context)
    : RecyclerView.Adapter<MyViewHolder>() {
    var items = ArrayList<MyModel>()
    var ctx: Context = context

    fun addItem(item: MyModel) {
        this.items.add(item)
        notifyItemInserted(items.size - 1)
    }

    fun addItems(items: List<MyModel>) {
        this.items.addAll(items)
        notifyDataSetChanged()
    }

    fun clearItems() {
        this.items.clear()
        notifyDataSetChanged()
    }

    fun updateItem(item: MyModel,updateIndex:Int){
        this.items.set(updateIndex,item)
        notifyItemChanged(updateIndex);
    }

    override fun onCreateViewHolder(p0: ViewGroup, p1: Int): MyViewHolder {
        val inflater = LayoutInflater.from(p0.context)
        return MyViewHolder(inflater, p0)
    }

    override fun getItemCount(): Int = items.size

    override fun onBindViewHolder(holder: MyViewHolder, pos: Int) {
        holder.bind(items[pos], ctx)
    }
}

class MyViewHolder(inflater: LayoutInflater, parent: ViewGroup) :
        RecyclerView.ViewHolder(inflater.inflate(R.layout.item_recyclerview, parent, false)) {

    fun bind(myModel: MyModel, context: Context) {
        itemView.appTextName.setText(myModel.packageName)
        if (myModel.isChinese) {
            itemView.appTextName.setBackgroundColor(ContextCompat.getColor(context, R.color.Red))
            itemView.appTextName.setTextColor(ContextCompat.getColor(context, R.color.White))
        } else {
            itemView.appTextName.setTextColor(ContextCompat.getColor(context, R.color.Black))
        }
    }
}