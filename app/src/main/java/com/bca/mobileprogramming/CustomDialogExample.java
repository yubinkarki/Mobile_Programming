package com.bca.mobileprogramming;

import android.app.Activity;
import android.app.AlertDialog;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class CustomDialogExample extends Activity {
    Button contextButton;

    @Override
    protected void onCreate(Bundle b) {
        super.onCreate(b);
        setContentView(R.layout.columns);

        contextButton = findViewById(R.id.context_button);

        contextButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showCalculatorDialog();
            }
        });
    }

    public void showCalculatorDialog() {
        AlertDialog.Builder builder = new AlertDialog.Builder(CustomDialogExample.this);

        builder.setTitle("Calculate Sum");
        builder.setCancelable(true);

        LayoutInflater inflater = getLayoutInflater();

        View view = inflater.inflate(R.layout.calculator_fragment, null);

        builder.setView(view);

        EditText firstNumberInput = view.findViewById(R.id.first_number_input);
        EditText secondNumberInput = view.findViewById(R.id.second_number_input);
        Button calculateButton = view.findViewById(R.id.calculate_button);
        TextView resultText = view.findViewById(R.id.result_text);

        calculateButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int first, second, result;

                first = Integer.parseInt(firstNumberInput.getText().toString());
                second = Integer.parseInt(secondNumberInput.getText().toString());

                result = first + second;

                resultText.setText("Result: " + result);
            }
        });

        AlertDialog alert = builder.create();
        alert.show();
    }
}
