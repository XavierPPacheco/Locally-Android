package com.parternship.locally.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.parternship.locally.R
import com.parternship.locally.entity.Item
import com.parternship.locally.entity.Subscription

class SubscriptionAdapter (private val dataSet : Array<Subscription>) : RecyclerView.Adapter<SubscriptionAdapter.ViewHolder>() {


    // Create new views (invoked by the layout manager)
    override fun onCreateViewHolder(viewGroup: ViewGroup, viewType: Int): ViewHolder {
        // Create a new view, which defines the UI of the list item
        val view = LayoutInflater.from(viewGroup.context)
            .inflate(R.layout.susbcription_item, viewGroup, false)

        return ViewHolder(view)
    }

    // Replace the contents of a view (invoked by the layout manager)
    override fun onBindViewHolder(viewHolder: ViewHolder, position: Int) {

        // Get element from your dataset at this position and replace the
        // contents of the view with that element
        viewHolder.name.text = dataSet[position].name
        viewHolder.price.text = dataSet[position].getPrice().toString()



    }

    // Return the size of your dataset (invoked by the layout manager)
    override fun getItemCount() = dataSet.size





class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val price : TextView
        val date : TextView
        val name : TextView

        init {
            // Define click listener for the ViewHolder's View.
            price = view.findViewById(R.id.sub_price)
            date = view.findViewById(R.id.sub_date)
            name = view.findViewById(R.id.sub_name)

        }
    }

    interface  OnSubscriptionListener{
      fun  onSubscriptionClick(subscription : Subscription)
    }

}