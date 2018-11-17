package com.lynx.increasedscholarshipsapp.myevent

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.RecyclerView
import android.support.v7.widget.StaggeredGridLayoutManager
import android.widget.TextView
import com.lynx.increasedscholarshipsapp.R
import com.lynx.increasedscholarshipsapp.event.adpter.EventsAdapter
import com.lynx.increasedscholarshipsapp.models.EventModel
import com.lynx.increasedscholarshipsapp.service.ServiceData

class MyEventActivity : AppCompatActivity() {

    private lateinit var mListEventView: RecyclerView
    private lateinit var mTabItemFeature: TextView
    private lateinit var mTabItemEnd: TextView
//    private lateinit var mListEventView:RecyclerView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_my_event)
        mTabItemEnd = findViewById(R.id.tab_end)
        mTabItemFeature = findViewById(R.id.tab_feature)

        mTabItemFeature.setOnClickListener {
            ServiceData.loadFeatureEvents {

                (mListEventView.adapter as EventsAdapter).listEvents = it
                (mListEventView.adapter as EventsAdapter).notifyDataSetChanged()
            }
        }
        mTabItemEnd.setOnClickListener {
            ServiceData.loadEndEvents {

            (mListEventView.adapter as EventsAdapter).listEvents = it
            (mListEventView.adapter as EventsAdapter).notifyDataSetChanged()
            }

        }

        mListEventView = findViewById(R.id.list_event)
        val modelsEvent = ArrayList<EventModel>()
        for (i in 0..10)
            modelsEvent.add(EventModel("StudOsen", "12.03.2019", "blallasdsaadaddasdadslaslalslaslasaslalsal", 23))
        mListEventView.layoutManager = StaggeredGridLayoutManager(2, StaggeredGridLayoutManager.VERTICAL)
        mListEventView.adapter = EventsAdapter(modelsEvent)

    }

}