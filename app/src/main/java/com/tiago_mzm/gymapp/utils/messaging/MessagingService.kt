package com.tiago_mzm.gymapp.utils.messaging

import android.util.Log
import com.google.firebase.messaging.FirebaseMessagingService
import com.google.firebase.messaging.RemoteMessage

class MessagingService: FirebaseMessagingService()  {

    override fun onMessageReceived(message: RemoteMessage) {

        Log.v("FirebaseNotification","FirebaseNotification" )
        Log.v("FirebaseNotification", message.notification?.title ?: "No tiene titulo")
        Log.v("FirebaseNotification", message.notification?.body ?: "No tiene titulo")
        message.data.forEach{
                (s,s2)-> Log.v("FirebaseNotification", "llave => $s")
                            Log.v("FirebaseNotification", "valor => $s2" +
                                    "")
        }

    }

    override fun onNewToken(token: String) {
        super.onNewToken(token)
    }
}