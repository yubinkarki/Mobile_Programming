package com.bca.mobileprogramming;

import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.ContextMenu;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.PopupMenu;
import android.widget.Toast;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

public class CommentOptions extends AppCompatActivity {
    Button contextMenuButton;
    Button optionMenuButton;

    @Override
    protected void onCreate(Bundle b) {
        super.onCreate(b);
        setContentView(R.layout.columns);

        ActionBar actionBar = getSupportActionBar();
        ColorDrawable colors = new ColorDrawable(Color.parseColor("#51B288"));

        actionBar.setBackgroundDrawable(colors);

        contextMenuButton = findViewById(R.id.context_button);
        optionMenuButton = findViewById(R.id.popup_button);

        registerForContextMenu(contextMenuButton);

        optionMenuButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                PopupMenu popup = new PopupMenu(CommentOptions.this, optionMenuButton);

                popup.getMenuInflater().inflate(R.menu.comment_options, popup.getMenu());

                popup.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener() {
                    @Override
                    public boolean onMenuItemClick(MenuItem item) {
                        Toast.makeText(CommentOptions.this,
                                "You clicked " + item.getTitle(), Toast.LENGTH_SHORT).show();

                        return true;
                    }
                });

                popup.show();
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();

        inflater.inflate(R.menu.comment_options, menu);

        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.services_option:
                System.out.println("This is services option.");
                return true;

            case R.id.about_option:
                System.out.println("This is about option.");
                return true;

            default:
                return super.onOptionsItemSelected(item);
        }
    }

    @Override
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {
        super.onCreateContextMenu(menu, v, menuInfo);

        MenuInflater inflater = getMenuInflater();

        inflater.inflate(R.menu.comment_options, menu);
    }

    @Override
    public boolean onContextItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.services_option:
                System.out.println("This is services context option.");
                return true;

            case R.id.about_option:
                System.out.println("This is about context option.");
                return true;

            default:
                return super.onContextItemSelected(item);
        }
    }
}
