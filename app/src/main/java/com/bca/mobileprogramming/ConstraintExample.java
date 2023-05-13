package com.bca.mobileprogramming;

import android.content.Intent;
import android.os.Bundle;
import android.app.Activity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.Toast;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.TextView;

import com.google.android.material.snackbar.Snackbar;

import androidx.constraintlayout.widget.ConstraintLayout;

public class ConstraintExample extends Activity {
    TextView headingText;
    Button navigateButton;
    RadioButton radioMale, radioFemale;
    Spinner countryList;
    Button saveButton;
    Button cancelButton;
    EditText fullNameInput;

    @Override
    public void onCreate(Bundle b) {
        super.onCreate(b);
        setContentView(R.layout.widget_example);

        countryList = findViewById(R.id.country_spinner);
        saveButton = findViewById(R.id.save_button);
        cancelButton = findViewById(R.id.cancel_button);
        fullNameInput = findViewById(R.id.full_name_input);
        navigateButton = findViewById(R.id.nav_button);
        headingText = findViewById(R.id.hello_text);
        radioMale = findViewById(R.id.gender_male);
        radioFemale = findViewById(R.id.gender_female);

        // String items[] = {"Choice 1", "Choice 2", "Choice 3", "Choice 4"};
        //ConstraintLayout widgetExampleRoot = findViewById(R.id.widget_example_root);


        // Adding toast message on save button click.
        saveButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getApplicationContext(), "Button Clicked!", Toast.LENGTH_SHORT).show();

                headingText.setText(fullNameInput.getText().toString());

                System.out.println("Button click print.");
            }
        });


        // Passing data to 2nd activity.
        /*navigateButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(ConstraintExample.this, AbsoluteExample.class);

                i.putExtra("id", 1);
                i.putExtra("name", "Thor");
                i.putExtra("address", "Kathmandu");
                i.putExtra("inputText", fullNameInput.getText().toString());

                startActivity(i);
            }
        });*/

        // Getting data from 2nd activity.
       /* navigateButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(ConstraintExample.this, LinearExample.class);

                startActivityForResult(i, 22);
            }
        });*/

        // Sending another data
        navigateButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String name = fullNameInput.getText().toString();
                String gender = "";

                if (radioMale.isChecked()){
                    gender = "Male";
                } else {
                    gender = "Female";
                }

                String country = countryList.getSelectedItem().toString();

                Intent i = new Intent(ConstraintExample.this, AbsoluteExample.class);

                i.putExtra("name", name);
                i.putExtra("gender", gender);
                i.putExtra("country", country);

                startActivity(i);
            }
        });
    }

    /*@Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (requestCode == 22) {
            String message = data.getStringExtra("message");

            headingText.setText(message);
        }
    }
*/
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
