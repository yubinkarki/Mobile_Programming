package com.bca.mobileprogramming;

import android.os.Bundle;
import android.util.Log;

import androidx.appcompat.app.AppCompatActivity;

public class ActivityLifeCycleExample extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle b) {
        super.onCreate(b);
        getSupportActionBar().hide();
        setContentView(R.layout.columns);

        Log.d("myStateLog", "onCreate");
    }

    @Override
    protected void onStart() {
        super.onStart();

        Log.d("myStateLog", "onStart");
    }

    @Override
    protected void onResume() {
        super.onResume();

        Log.d("myStateLog", "onResume");
    }

    @Override
    protected void onRestart() {
        super.onRestart();

        Log.d("myStateLog", "onRestart");
    }

    @Override
    protected void onPause() {
        super.onPause();

        Log.d("myStateLog", "onPause");
    }

    @Override
    protected void onStop() {
        super.onStop();

        Log.d("myStateLog", "onStop");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();

        Log.d("myStateLog", "onDestroy");
    }
}
