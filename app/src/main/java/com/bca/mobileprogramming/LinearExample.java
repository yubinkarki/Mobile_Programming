package com.bca.mobileprogramming; // Declaring package name.

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class LinearExample extends Activity {
    Button submitButton;

    @Override
    public void onCreate(Bundle b) { // Bundle stores the state of the activity.
        super.onCreate(b); // Called when the activity is first created. Initializes the UI.
        setContentView(R.layout.first); // Inflates layout and displays on screen.

        TextView titleTextView = findViewById(R.id.title_text);

        submitButton = findViewById(R.id.submit_button);

        // Receiving data.
        Intent i = getIntent();
        int id = i.getIntExtra("id", 0);
        String name = i.getStringExtra("name");
        String address = i.getStringExtra("address");
        String inputText = i.getStringExtra("inputText");

        // titleTextView.setText("Id = " + id + "\n" + "Name = " + name + "\n" + "Address = " + address);
        titleTextView.setText("Input text: " + address);

        submitButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent();

                i.putExtra("message", "2nd activity");

                setResult(22, i);

                finish();
            }
        });
    }

    @Override
    protected void onStart() {
        super.onStart();

        Log.d("myStateLog", "onStart - 2");
    }

    @Override
    protected void onResume() {
        super.onResume();

        Log.d("myStateLog", "onResume - 2");
    }

    @Override
    protected void onRestart() {
        super.onRestart();

        Log.d("myStateLog", "onRestart - 2");
    }

    @Override
    protected void onPause() {
        super.onPause();

        Log.d("myStateLog", "onPause - 2");
    }

    @Override
    protected void onStop() {
        super.onStop();

        Log.d("myStateLog", "onStop - 2");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();

        Log.d("myStateLog", "onDestroy - 2");
    }
}
