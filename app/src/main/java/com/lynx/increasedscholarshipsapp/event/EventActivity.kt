package com.lynx.increasedscholarshipsapp.event

import android.content.Intent
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import com.lynx.increasedscholarshipsapp.R
import com.lynx.increasedscholarshipsapp.event.adpter.EventsAdapter
import com.lynx.increasedscholarshipsapp.models.EventModel
import com.lynx.increasedscholarshipsapp.myevent.MyEventActivity
import com.lynx.increasedscholarshipsapp.service.ServiceData

class EventActivity : AppCompatActivity() {

    private lateinit var mListEventView: RecyclerView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_event)

        mListEventView = findViewById(R.id.list_event)
        ServiceData.loadAllEvents {

      mListEventView.layoutManager = LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false)
        mListEventView.adapter = EventsAdapter(it)
        }

    }

    override fun onBackPressed() {
        startActivity(Intent(this, MyEventActivity::class.java))
    }

}