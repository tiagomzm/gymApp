package com.tiago_mzm.gymapp.utils.messaging

import android.annotation.SuppressLint
import android.app.NotificationChannel
import android.app.NotificationManager
import android.app.PendingIntent
import android.content.Context
import android.content.Intent
import android.os.Build
import android.widget.RemoteViews
import android.widget.RemoteViews.RemoteView
import androidx.core.app.NotificationCompat
import com.google.firebase.messaging.FirebaseMessagingService
import com.google.firebase.messaging.RemoteMessage
import com.tiago_mzm.gymapp.MainActivity
import com.tiago_mzm.gymapp.R
import kotlinx.coroutines.flow.channelFlow

/*const val codigoCanal = "notificacion_canal"
const val nombreCanal = "com.tiago_mzm.gymapp.utils.messaging"*/
class MessagingService: FirebaseMessagingService() {

    /*override fun onMessageReceived(remoteMessage: RemoteMessage) {
        if (remoteMessage.notification != null){
            generarNotificacion(remoteMessage.notification!!.title!!,remoteMessage.notification!!.body!!)
        }
    }

    @SuppressLint("VistaRemotaLayout")
    fun obtenerVistaRemota(title: String,mensaje: String): RemoteViews {
        val vistaRemota = RemoteViews("com.tiago_mzm.gymapp.utils.messaging",R.layout.notification)
        vistaRemota.setTextViewText(R.id.titulo,title)
        vistaRemota.setTextViewText(R.id.mensaje,mensaje)
        vistaRemota.setImageViewResource(R.id.app_logo,R.drawable.logopesas)
        return vistaRemota
    }

    fun generarNotificacion(title: String, mensaje:String){

        val interador = Intent(this,MainActivity::class.java)
        interador.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP)

        val pendienteInterador = PendingIntent.getActivity(this,0,interador,
            PendingIntent.FLAG_ONE_SHOT or PendingIntent.FLAG_IMMUTABLE)
        var builder:NotificationCompat.Builder = NotificationCompat.Builder(applicationContext,
            codigoCanal)
            .setSmallIcon(R.drawable.logopesas)
            .setAutoCancel(true)
            .setVibrate(longArrayOf(1000,1000,1000,1000))
            .setOnlyAlertOnce(true)
            .setContentIntent(pendienteInterador)

        builder = builder.setContent(obtenerVistaRemota(title,mensaje) )

        val administracionNotificacion = getSystemService(Context.NOTIFICATION_SERVICE) as NotificationManager

        if(Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            val notificationChannel = NotificationChannel(codigoCanal, nombreCanal, NotificationManager.IMPORTANCE_HIGH)
            administracionNotificacion.createNotificationChannel(notificationChannel)
        }

        administracionNotificacion.notify(0, builder.build())
    }*/

}