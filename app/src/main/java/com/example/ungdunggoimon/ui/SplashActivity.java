package com.example.ungdunggoimon.ui;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.example.ungdunggoimon.App;
import com.example.ungdunggoimon.R;
import com.example.ungdunggoimon.utils.Constance;

public  class SplashActivity extends AppCompatActivity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);
        new Handler(Looper.myLooper()).postDelayed(() -> {
            SharedPreferences preferences = getSharedPreferences(Constance.PREFERENCES_NAME, MODE_PRIVATE);
            String username = preferences.getString(Constance.USERNAME, null);
            String password = preferences.getString(Constance.PASSWORD, null);
            if (username != null && password != null) {
                ((App) getApplicationContext()).login(username, password, this);
                return;
            }
            Intent intent = new Intent(SplashActivity.this, LoginActivity.class);
            startActivity(intent);
            finish();
        }, 2000);
    }
}