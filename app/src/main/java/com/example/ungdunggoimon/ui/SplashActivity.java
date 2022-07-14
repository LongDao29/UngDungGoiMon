package com.example.ungdunggoimon.ui;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.example.ungdunggoimon.MainActivity;
import com.example.ungdunggoimon.R;

public  class SplashActivity extends AppCompatActivity {
    @Override
protected  void onCreate(@Nullable Bundle savedInstanceState){
super.onCreate(savedInstanceState);
setContentView(R.layout.activity_splash);
new Handler(Looper.myLooper()).postDelayed(()->{
    Intent intent =new Intent(SplashActivity.this, MainActivity.class);
    startActivity(intent);
},2000);
    }
}