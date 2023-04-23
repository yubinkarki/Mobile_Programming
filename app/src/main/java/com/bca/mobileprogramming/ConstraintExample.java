package com.bca.mobileprogramming;

import android.os.Bundle;
import android.app.Activity;
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
    @Override
    public void onCreate(Bundle b) {


        super.onCreate(b);
        setContentView(R.layout.widget_example);

        String items[] = {"Choice 1", "Choice 2", "Choice 3", "Choice 4"};

        Spinner spinner = findViewById(R.id.country_spinner);
        Button saveButton = findViewById(R.id.save_button);
        Button cancelButton = findViewById(R.id.cancel_button);
        ConstraintLayout widgetExampleRoot = findViewById(R.id.widget_example_root);
        TextView headingText = findViewById(R.id.hello_text);
        EditText fullNameInput = findViewById(R.id.full_name_input);

        String fullNameInputData = fullNameInput.getText().toString();

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
    }
}

// Setting custom dropdown list for spinner.
/*ArrayAdapter<String> spinnerArrayAdapter = new ArrayAdapter<String>(this, R.layout.runtime_list, R.id.list_textview, items);
spinner.setAdapter(spinnerArrayAdapter);*/
