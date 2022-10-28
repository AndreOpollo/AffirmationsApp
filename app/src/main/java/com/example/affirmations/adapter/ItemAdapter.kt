package com.example.affirmations.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.affirmations.R
import com.example.affirmations.model.Affirmations

/**
 * Adapter for the RecycleView in the MainActivity. Displays the Affirmation data object
 */
class ItemAdapter(private val context: Context, private val dataset: List<Affirmations>) :
    RecyclerView.Adapter<ItemAdapter.ItemViewHolder>(){
    //Provides reference to the views for  each data item
    //Complex data items may need more than one view per item, and you provide access to all the
    //views for a data item in the viewHolder
    //Each data item is just an affirmation holder
    class ItemViewHolder(private val view: View) : RecyclerView.ViewHolder(view) {
        val textView: TextView = view.findViewById(R.id.item_title)
        val imageView: ImageView = view.findViewById(R.id.item_image)

    }

    /**
     * create new views. Invoked by layout manager
     */
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ItemViewHolder {
        //create new view
        val adapterLayout = LayoutInflater.from(parent.context).inflate(R.layout.list_item,parent,false)
        return ItemViewHolder(adapterLayout)
    }

    /**
     * Replaces the contents of a view. Invoked by layout manager
     */
    override fun onBindViewHolder(holder: ItemViewHolder, position: Int) {
        val item = dataset[position]
        holder.textView.text = context.resources.getString(item.stringResourceId)
        holder.imageView.setImageResource(item.imageResourceId)
    }

    /**
     * returns the size of your dataset. Invoked by the layout manager
     */
    override fun getItemCount() = dataset.size
}