package com.bca.mobileprogramming;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.GridView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

public class GridViewMain extends AppCompatActivity {
    GridView gridView;

    @Override
    protected void onCreate(Bundle b) {
        super.onCreate(b);

        // The main layout which has grid view widget.
        setContentView(R.layout.grid_view_main);

        // The particular grid view widget that is going to populate items.
        gridView = findViewById(R.id.grid_view_list);

        // Adding items to the grid view widget.
        String[] names = {"Person 1", "Person 2", "Person 3", "Person 4", "Person 5",
                "Person 1", "Person 2", "Person 3", "Person 4", "Person 5",
                "Person 1", "Person 2", "Person 3", "Person 4", "Person 5",
                "Person 1", "Person 2", "Person 3", "Person 4", "Person 5",
                "Person 1", "Person 2", "Person 3", "Person 4", "Person 5",
                "Person 1", "Person 2", "Person 3", "Person 4", "Person 5"};

        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,
                R.layout.grid_view_item, R.id.grid_view_text, names);

        gridView.setAdapter(adapter);

        gridView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                String value = adapter.getItem(position);

                Toast.makeText(getApplicationContext(), value, Toast.LENGTH_SHORT).show();
            }
        });
    }
}
