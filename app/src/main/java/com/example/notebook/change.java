package com.example.notebook;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.app.AppCompatDelegate;

public class change extends AppCompatActivity {
    private SharedPreferences congig;
    private SharedPreferences.Editor edit;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        congig = getSharedPreferences("config", MODE_PRIVATE);
        edit = congig.edit();
        setContentView(R.layout.activity_change);

        findViewById(R.id.daytime).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //夜间 切换 日间
                AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_YES);
                edit.putBoolean("isnight",true).commit();
            }
        });
        findViewById(R.id.night).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //日间 切换 夜间
                AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO);
                edit.putBoolean("isnight",false).commit();
            }
        });
    }
}
