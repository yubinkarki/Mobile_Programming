package com.bca.mobileprogramming;

import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

public class ListViewMain extends AppCompatActivity {
    ListView listView;

    @Override
    protected void onCreate(Bundle b) {
        super.onCreate(b);

        // The main layout which has list view widget.
        setContentView(R.layout.list_view_main);

        ActionBar actionBar = getSupportActionBar();
        ColorDrawable colors = new ColorDrawable(Color.parseColor("#51B288"));

        actionBar.setBackgroundDrawable(colors);

        // The particular list view widget that is going to populate items.
        listView = findViewById(R.id.list_view);

        // Adding items to the list view widget.
        String[] names = {"Person 1", "Person 2", "Person 3", "Person 4", "Person 5",
                "Person 1", "Person 2", "Person 3", "Person 4", "Person 5",
                "Person 1", "Person 2", "Person 3", "Person 4", "Person 5",
                "Person 1", "Person 2", "Person 3", "Person 4", "Person 5",
                "Person 1", "Person 2", "Person 3", "Person 4", "Person 5",
                "Person 1", "Person 2", "Person 3", "Person 4", "Person 5"};

        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,
                R.layout.list_view_item, R.id.list_view_text, names);

        listView.setAdapter(adapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                String value = adapter.getItem(position);

                Toast.makeText(getApplicationContext(), value, Toast.LENGTH_SHORT).show();
            }
        });
    }
}
