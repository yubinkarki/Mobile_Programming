package com.bca.mobileprogramming;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

public class AbsoluteExample extends Activity {
    TextView resultView;

    @Override
    public void onCreate(Bundle b) {
        super.onCreate(b);
        setContentView(R.layout.absolute_example);

        resultView = findViewById(R.id.resultView);

        // Receiving data.
        Intent i = getIntent();

        String name = i.getStringExtra("name");
        String gender = i.getStringExtra("gender");
        String country = i.getStringExtra("country");

        resultView.setText("Student name: " + name + "\n" +
                "Student gender: " + gender + "\n" +
                "Country of residence: " + country);
    }
}
