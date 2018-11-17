package com.lynx.increasedscholarshipsapp.event.view

import android.support.v7.widget.RecyclerView
import android.view.View
import android.widget.TextView
import com.lynx.increasedscholarshipsapp.R
import com.lynx.increasedscholarshipsapp.models.EventModel

class EventHolder(var view: View) : RecyclerView.ViewHolder(view) {

    var isTabBtnGo = true
    private lateinit var mTxtName: TextView
    private lateinit var mTxtDate: TextView
    private lateinit var mTxtDiscription: TextView
    private lateinit var mTxtCountPeople: TextView
    private lateinit var mBtnGo: TextView

    fun onBind(eventModel: EventModel) {
        mTxtName = view.findViewById(R.id.name)
        mTxtDate = view.findViewById(R.id.date)
        mTxtDiscription = view.findViewById(R.id.discrip)
        mTxtCountPeople = view.findViewById(R.id.people_count)
        mBtnGo = view.findViewById(R.id.btn_go)

        mTxtName.text = eventModel.name
        mTxtDiscription.text = eventModel.discription
        mTxtDate.text = eventModel.date
        mTxtCountPeople.text = "Количестово участников 0/${eventModel.countPeople}"
        check()
        mBtnGo.setOnClickListener {
            isTabBtnGo = !isTabBtnGo
            check()

        }

    }

    fun check() {
        if (isTabBtnGo) {
            mBtnGo.setBackgroundResource(R.drawable.event_bg_grey)
            mBtnGo.text = "не иду"
        } else {
            mBtnGo.setBackgroundResource(R.drawable.event_bg_green)
            mBtnGo.text = "иду"
        }
    }
}