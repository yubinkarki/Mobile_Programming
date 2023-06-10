package com.bca.mobileprogramming;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

public class FragmentSwitcher extends FragmentActivity {
    Button fragmentOneButton;
    Button fragmentTwoButton;

    @Override
    protected void onCreate(Bundle b) {
        super.onCreate(b);
        setContentView(R.layout.fragment_switcher);

        fragmentOneButton = findViewById(R.id.first_button);
        fragmentTwoButton = findViewById(R.id.second_button);

        fragmentOneButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Fragment fragmentOne = new FragmentOne();
                FragmentManager manager = getSupportFragmentManager();
                FragmentTransaction transaction = manager.beginTransaction();

                transaction.add(R.id.fragment_switch, fragmentOne);
                transaction.commit();
            }
        });

        fragmentTwoButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Fragment fragmentTwo = new FragmentTwo();
                FragmentManager manager = getSupportFragmentManager();
                FragmentTransaction transaction = manager.beginTransaction();

                transaction.add(R.id.fragment_switch, fragmentTwo);
                transaction.commit();
            }
        });
    }
}
