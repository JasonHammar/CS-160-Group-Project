package com.example.cs160cashew;

import android.app.Application;

import java.util.Timer;
import java.util.TimerTask;

public class MyApp extends Application {

    private LogoutListener listener;

    public void startUserSession() {
        Timer timer = new Timer();
        timer.schedule(new TimerTask() {
            @Override
            public void run() {
                listener.onSessionLogout();
            }
        }, 5000);
    }

    public void registerSessionListener(LogoutListener listener) {
        this.listener = listener;
    }
}
