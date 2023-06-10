package com.bca.mobileprogramming;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class AlertDialogExample extends Activity {
    Button holdMeButton;
    Button clickMeButton;

    @Override
    protected void onCreate(Bundle b) {
        super.onCreate(b);
        setContentView(R.layout.columns);

        holdMeButton = findViewById(R.id.context_button);
        clickMeButton = findViewById(R.id.popup_button);

        holdMeButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showDialog();
            }
        });
    }

    public void showDialog() {
        AlertDialog.Builder builder = new AlertDialog.Builder(AlertDialogExample.this);

        builder.setTitle("Exit App");
        builder.setMessage("Are you sure?");
        builder.setCancelable(true);

        builder.setPositiveButton("Yes", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                System.out.println("Yes button pressed on dialog");
            }
        });

        builder.setNegativeButton("No", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                System.out.println("No button pressed on dialog");
            }
        });

        AlertDialog alert = builder.create();
        alert.show();
    }
}
