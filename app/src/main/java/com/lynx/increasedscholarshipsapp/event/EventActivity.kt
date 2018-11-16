package com.lynx.increasedscholarshipsapp.event

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.support.v7.widget.StaggeredGridLayoutManager
import com.lynx.increasedscholarshipsapp.R
import com.lynx.increasedscholarshipsapp.event.adpter.EventsAdapter
import com.lynx.increasedscholarshipsapp.models.EventModel

class EventActivity:AppCompatActivity() {

    private lateinit var mListEventView:RecyclerView
//    private lateinit var mListEventView:RecyclerView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_event)

        mListEventView = findViewById(R.id.list_event)
        val modelsEvent = ArrayList<EventModel>()
        for (i in 0..10)
            modelsEvent.add(EventModel("StudOsen","12.03.2019","blallaslaslalslaslasaslalsal",123))
        mListEventView.layoutManager = LinearLayoutManager(this,LinearLayoutManager.VERTICAL,false)
        mListEventView.adapter = EventsAdapter(modelsEvent)

    }
}