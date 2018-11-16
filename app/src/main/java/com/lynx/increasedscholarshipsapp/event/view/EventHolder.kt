package com.lynx.increasedscholarshipsapp.event.view

import android.support.v7.widget.RecyclerView
import android.view.View
import android.widget.TextView
import com.lynx.increasedscholarshipsapp.R
import com.lynx.increasedscholarshipsapp.models.EventModel

class EventHolder(var view: View):RecyclerView.ViewHolder(view) {

    var isTabBtnGo = false
    private lateinit var mTxtName:TextView
    private lateinit var mTxtDate:TextView
    private lateinit var mTxtDiscription:TextView
    private lateinit var mTxtCountPepole:TextView
    private lateinit var mBtnGo:TextView

    fun onBind(eventModel: EventModel) {
        mTxtName = view.findViewById(R.id.name)
        mTxtDate = view.findViewById(R.id.date)
        mTxtDiscription = view.findViewById(R.id.discrip)
        mTxtCountPepole = view.findViewById(R.id.people_count)
        mBtnGo = view.findViewById(R.id.btn_go)

        mTxtName.text  = eventModel.name
        mTxtDiscription.text = eventModel.discription
        mTxtDate.text = eventModel.date
        mTxtCountPepole.text = "0/${eventModel.countPeople}"

        mBtnGo.setOnClickListener {
            isTabBtnGo  = !isTabBtnGo
            if (isTabBtnGo){
                mBtnGo.setBackgroundResource(R.drawable.event_bg_grey)
            }else{
                mBtnGo.setBackgroundResource(R.drawable.event_bg_green)
            }
        }
    }
}