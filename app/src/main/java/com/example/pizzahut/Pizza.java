package com.example.pizzahut;

import android.app.Application;

import prihanofficial.com.kokis.helpers.Mode;
import prihanofficial.com.kokis.helpers.UserDefault;
import prihanofficial.com.kokis.logics.Kokis;

public class Pizza extends Application {
    @Override
    public void onCreate() {
        super.onCreate();

        Kokis.setContext(this)
                .setSharedPreferencesName(getPackageName())
                .setMode(Mode.PRIVATE)
                .setUseDefaultSharedPreference(UserDefault.NO)
                .build();
    }

    @Override
    public void onTerminate() {
        super.onTerminate();
    }
}
