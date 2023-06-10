package com.bca.mobileprogramming;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;

import androidx.fragment.app.FragmentActivity;

public class FragmentOneTwo extends FragmentActivity {
    @Override
    protected void onCreate(Bundle b) {
        try {
            super.onCreate(b);

            setContentView(R.layout.fragment_one_two);
        } catch (Exception e) {
            Log.d("DebuggingFragmentError", "onCreate of main activity", e);

            throw e;
        }
    }
}
