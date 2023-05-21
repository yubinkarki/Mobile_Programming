package com.bca.mobileprogramming;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.fragment.app.Fragment;

public class CalculatorFragment extends Fragment {
    EditText firstNumber;
    EditText secondNumber;
    Button calculateButton;
    TextView resultText;

    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle b) {
        View view = inflater.inflate(R.layout.caculator_fragment, container, false);

        firstNumber = view.findViewById(R.id.first_number_input);
        secondNumber = view.findViewById(R.id.second_number_input);
        calculateButton = view.findViewById(R.id.calculate_button);
        resultText = view.findViewById(R.id.result_text);

        calculateButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int first = Integer.parseInt(firstNumber.getText().toString());
                int second = Integer.parseInt(secondNumber.getText().toString());

                int result = first + second;

                resultText.setText("Result: " + result);
            }
        });

        return view;
    }
}
