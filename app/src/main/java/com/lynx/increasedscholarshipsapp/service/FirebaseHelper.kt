package com.lynx.increasedscholarshipsapp.service

import com.google.firebase.database.FirebaseDatabase

class FirebaseHelper {

    companion object {

        fun getAllEvents() {
            val bd = FirebaseDatabase.getInstance().getReference("allEvents")
        }

        fun getEndEvents() {
            val bd = FirebaseDatabase.getInstance().getReference("endEvents")

        }

        fun getFeatureEvents() {
            val bd = FirebaseDatabase.getInstance().getReference("featureEvents")

        }
    }


}