package com.lynx.increasedscholarshipsapp.event.adpter

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.ViewGroup
import com.lynx.increasedscholarshipsapp.R
import com.lynx.increasedscholarshipsapp.event.view.EventHolder
import com.lynx.increasedscholarshipsapp.models.EventModel

class EventsAdapter(var listEvents:ArrayList<EventModel>): RecyclerView.Adapter<EventHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): EventHolder {
     val view = LayoutInflater.from(parent.context).inflate(R.layout.view_holder_event,parent,false)
        return EventHolder(view)
    }

    override fun getItemCount(): Int {
        return listEvents.size
    }

    override fun onBindViewHolder(holder: EventHolder, position: Int) {
        holder.onBind(listEvents[position])
    }

//    interface EventViewListener{
//        fun clickGo()
//    }
}