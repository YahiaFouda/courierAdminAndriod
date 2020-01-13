package com.twoam.agent.adapter

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.twoam.agent.R
import com.twoam.agent.callback.IBottomSheetCallback
import com.twoam.agent.model.Stop
import com.twoam.agent.utilities.AppConstants

import java.util.ArrayList


/**
 * Created by Mokhtar on 1/8/2020.
 */

class StopAdapter(private val context: Context, private val stopList: ArrayList<Stop>)
    : RecyclerView.Adapter<StopAdapter.MyViewHolder>() {

    private val inflater: LayoutInflater = LayoutInflater.from(context)
    private var stop: Stop = Stop()
    private var listener: IBottomSheetCallback? = null

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): StopAdapter.MyViewHolder {

        val view = inflater.inflate(R.layout.task_layout, parent, false)
        return MyViewHolder(view)

    }

    override fun onBindViewHolder(holder: StopAdapter.MyViewHolder, position: Int) {
        stop = stopList[position]

        holder.tvUserName.text = stop.name
        holder.tvStopDetails.text = stop.description
        holder.tvPickupLocation.text = stop.pickUpLocation.name

    }

    override fun getItemCount(): Int {
        return stopList.size
    }

    override fun getItemId(position: Int): Long {
        return super.getItemId(position)
    }


    inner class MyViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        var tvUserName: TextView = itemView.findViewById(R.id.tvUserName)
        var tvStopDetails: TextView = itemView.findViewById(R.id.tvTaskDetails)
        var tvPickupLocation: TextView = itemView.findViewById(R.id.tvPickupLocation)


        init {


            itemView.setOnClickListener {
                val pos = adapterPosition
                stop = stopList[pos]
                AppConstants.CurrentSelectedStop = stop
                //switch to map fragment
              //  context.startActivity(Intent(context, LocationDetailsActivity::class.java))

            }

        }
    }
}
