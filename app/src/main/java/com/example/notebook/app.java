package com.example.notebook;

import android.app.Application;
import android.content.SharedPreferences;

import androidx.appcompat.app.AppCompatDelegate;

public class app extends Application {

    private SharedPreferences congig;
    private SharedPreferences.Editor edit;

    @Override
    public void onCreate() {
        super.onCreate();
        congig = getSharedPreferences("config", MODE_PRIVATE);
        edit = congig.edit();
        boolean isnight = congig.getBoolean("isnight", true);
        if (isnight){
            AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_YES);
        }else {
            AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO);
        }
    }
}

