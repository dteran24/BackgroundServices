package com.example.backgroundservices

import android.app.Service
import android.content.Intent
import android.media.MediaPlayer
import android.os.Binder
import android.os.IBinder
import android.util.Log
import java.util.*

class MyService : Service() {
    companion object{
        var TAG = MyService::class.java.simpleName
    }

    private val mBinder = LocalBinder()

    private val mGenerator = Random()

    val randomNumber: Int
        get() = mGenerator.nextInt(9999)

    fun getWeatherJson(cityName:String):String{
        return  "{temp:23}"+cityName
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
        return mBinder
    }

    inner class LocalBinder : Binder() {
        // Return this instance of LocalService so clients can call public methods
        fun getService(): MyService = this@MyService
    }

}