package com.bca.mobileprogramming;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;

public class FragmentOneTwo extends Activity {
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
