package com.bca.mobileprogramming;

import android.content.Intent;
import android.os.Bundle;
import android.app.Activity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.TextView;

import com.google.android.material.snackbar.Snackbar;

import androidx.constraintlayout.widget.ConstraintLayout;

public class ConstraintExample extends Activity {
    TextView headingText;
    Button navigateButton;

    @Override
    public void onCreate(Bundle b) {
        super.onCreate(b);
        setContentView(R.layout.widget_example);

        String items[] = {"Choice 1", "Choice 2", "Choice 3", "Choice 4"};

        Spinner spinner = findViewById(R.id.country_spinner);
        Button saveButton = findViewById(R.id.save_button);
        Button cancelButton = findViewById(R.id.cancel_button);
        EditText fullNameInput = findViewById(R.id.full_name_input);
        ConstraintLayout widgetExampleRoot = findViewById(R.id.widget_example_root);

        headingText = findViewById(R.id.hello_text);
        navigateButton = findViewById(R.id.nav_button);

        // Adding toast message on save button click.
        saveButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getApplicationContext(), "Button Clicked!", Toast.LENGTH_SHORT).show();

                headingText.setText(fullNameInput.getText().toString());

                System.out.println("Button click print.");
            }
        });

        // Adding snackbar on cancel button click.
        cancelButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Snackbar snackbar = Snackbar.make(widgetExampleRoot, "Deleted", Snackbar.LENGTH_SHORT);
                snackbar.show();
            }
        });

        // Passing data to 2nd activity.
        /*navigateButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(ConstraintExample.this, LinearExample.class);

                i.putExtra("id", 1);
                i.putExtra("name", "Thor");
                i.putExtra("address", "Kathmandu");
                i.putExtra("inputText", fullNameInput.getText().toString());

                startActivity(i);
            }
        });*/

        // Getting data from 2nd activity.
        navigateButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(ConstraintExample.this, LinearExample.class);

                startActivityForResult(i, 22);
            }
        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (requestCode == 22) {
            String message = data.getStringExtra("message");

            headingText.setText(message);
        }
    }

    @Override
    protected void onStart() {
        super.onStart();

        Log.d("myStateLog", "onStart - 1");
    }

    @Override
    protected void onResume() {
        super.onResume();

        Log.d("myStateLog", "onResume - 1");
    }

    @Override
    protected void onRestart() {
        super.onRestart();

        Log.d("myStateLog", "onRestart - 1");
    }

    @Override
    protected void onPause() {
        super.onPause();

        Log.d("myStateLog", "onPause - 1");
    }

    @Override
    protected void onStop() {
        super.onStop();

        Log.d("myStateLog", "onStop - 1");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();

        Log.d("myStateLog", "onDestroy - 1");
    }
}

// Setting custom dropdown list for spinner.
/*ArrayAdapter<String> spinnerArrayAdapter = new ArrayAdapter<String>(this, R.layout.runtime_list, R.id.list_textview, items);
spinner.setAdapter(spinnerArrayAdapter);*/
