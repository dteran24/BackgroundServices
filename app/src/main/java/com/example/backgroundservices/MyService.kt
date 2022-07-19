package com.example.backgroundservices

import android.app.Service
import android.content.Intent
import android.media.MediaPlayer
import android.os.IBinder
import android.util.Log

class MyService : Service() {
    companion object{
        var TAG = MyService::class.java.simpleName
    }

    override fun onCreate() {
        super.onCreate()
        Log.i(TAG,"Service created")

    }

    override fun onStartCommand(intent: Intent?, flags: Int, startId: Int): Int {

        super.onStartCommand(intent, flags, startId)
        var musicfile = intent?.getStringExtra("musicname")
        var mediaplayer: MediaPlayer = MediaPlayer.create(this, R.raw.sample)
        mediaplayer.start()
        Log.i(TAG,musicfile.toString())
        return START_STICKY
    }

    override fun onDestroy() {
        super.onDestroy()
    }

    override fun onBind(intent: Intent): IBinder {
        TODO("Return the communication channel to the service.")
    }
}