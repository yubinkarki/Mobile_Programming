package com.bca.mobileprogramming; // Declaring package name.

import android.app.Activity;
import android.os.Bundle;

public class LinearExample extends Activity {
    @Override
    public void onCreate(Bundle b) { // Bundle stores the state of the activity.
        super.onCreate(b); // Called when the activity is first created. Initializes the UI.
        setContentView(R.layout.linear_example); // Inflates layout and displays on screen.
    }
}
