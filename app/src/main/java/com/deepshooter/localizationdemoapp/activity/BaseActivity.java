package com.deepshooter.localizationdemoapp.activity;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;

import com.deepshooter.localizationdemoapp.App;
import com.deepshooter.localizationdemoapp.utils.Utility;

public abstract class BaseActivity extends AppCompatActivity {

    private static final String TAG = "BaseActivity";

    @Override
    protected void attachBaseContext(Context base) {
        super.attachBaseContext(App.localeManager.setLocale(base));
        Log.d(TAG, "attachBaseContext");
    }

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Log.d(TAG, "onCreate");
        Utility.resetActivityTitle(this);
    }



}