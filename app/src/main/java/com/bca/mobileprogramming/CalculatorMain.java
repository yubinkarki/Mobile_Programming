package com.bca.mobileprogramming;

import android.os.Bundle;
import android.util.Log;

import androidx.fragment.app.FragmentActivity;

public class CalculatorMain extends FragmentActivity {
    @Override
    protected void onCreate(Bundle b) {
        try {
            super.onCreate(b);

            setContentView(R.layout.calculator_main);
        } catch (Exception e) {
            Log.d("DebuggingFragmentError", "onCreate of main activity", e);

            throw e;
        }
    }
}
