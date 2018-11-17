package com.lynx.increasedscholarshipsapp.service

import com.lynx.increasedscholarshipsapp.models.EventModel

class ServiceData {


    //здесь берем данные из фаербейса
    companion object {


        fun loadAllEvents(complete: (models: ArrayList<EventModel>) -> Unit) {
            val modelsEvent = ArrayList<EventModel>()
            for (i in 0..10)
                modelsEvent.add(EventModel("StudOsen", "12.03.2019", "blallaslaslalslaslasaslalsal", 123))

            complete(modelsEvent)
        }

        fun loadEndEvents(complete: (models: ArrayList<EventModel>) -> Unit) {
            val modelsEvent = ArrayList<EventModel>()
            for (i in 0..10)
                modelsEvent.add(EventModel("StudOsen", "12.03.2019", "blallaslaslalslaslasaslalsal", 123))
            complete(modelsEvent)
        }

        fun loadFeatureEvents(complete: (models: ArrayList<EventModel>) -> Unit) {
            val modelsEvent = ArrayList<EventModel>()
            for (i in 0..10)
                modelsEvent.add(EventModel("StudOsen", "12.03.2019", "blallaslaslalslaslasaslalsal", 123))

            complete(modelsEvent)
        }


    }
}