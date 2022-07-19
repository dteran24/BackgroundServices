package com.example.backgroundservices;

import androidx.appcompat.app.AppCompatActivity;

import android.content.ComponentName;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.Bundle;
import android.os.IBinder;
import android.util.Log;
import android.view.View;

public class MainActivity extends AppCompatActivity {
    private static String TAG = MainActivity.class.getSimpleName();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void startService(View view) {
            Intent servIntent = new Intent(this, MyService.class);
            servIntent.putExtra("musicname","sample.mp3");
            //startService(servIntent); //This creates a service
            bindService(servIntent, serviceConnection, BIND_AUTO_CREATE);


    }

    ServiceConnection serviceConnection = new ServiceConnection() {
        @Override
        public void onServiceConnected(ComponentName componentName, IBinder mBinder) {
            MyService.LocalBinder binder = (MyService.LocalBinder) mBinder;
            MyService myService = binder.getService();
            int randomNum = myService.getRandomNumber();
            String getFile = myService.getWeatherJson("Houston");
            Log.i(TAG, "Random num is "+randomNum);
            Log.i(TAG, "Weather is "+ getFile);

        }

        @Override
        public void onServiceDisconnected(ComponentName componentName) {

        }
    };




    }
