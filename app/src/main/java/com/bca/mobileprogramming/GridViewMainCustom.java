package com.bca.mobileprogramming;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class GridViewMainCustom extends AppCompatActivity {
    GridView gridView;

    @Override
    protected void onCreate(Bundle b) {
        super.onCreate(b);

        // The main layout which has list view widget.
        setContentView(R.layout.grid_view_main);

        // The particular list view widget that is going to populate items.
        gridView = findViewById(R.id.grid_view_list);

        String[] title = {"Title 1", "Title 1", "Title 1", "Title 1", "Title 1", "Title 1",
                "Title 1", "Title 1", "Title 1", "Title 1", "Title 1", "Title 1", "Title 1",
                "Title 1", "Title 1", "Title 1", "Title 1"};

        String[] description = {"This is description 1.", "This is description 1.", "This is description 1.", "This is description 1.", "This is description 1.", "This is description 1.",
                "This is description 1.", "This is description 1.", "This is description 1.", "This is description 1.", "This is description 1.", "This is description 1.", "This is description 1.",
                "This is description 1.", "This is description 1.", "This is description 1.", "This is description 1."};

        int[] image = {R.drawable.ic_launcher_background, R.drawable.ic_launcher_background, R.drawable.ic_launcher_background, R.drawable.ic_launcher_background, R.drawable.ic_launcher_background, R.drawable.ic_launcher_background,
                R.drawable.ic_launcher_background, R.drawable.ic_launcher_background, R.drawable.ic_launcher_background, R.drawable.ic_launcher_background, R.drawable.ic_launcher_background, R.drawable.ic_launcher_background, R.drawable.ic_launcher_background,
                R.drawable.ic_launcher_background, R.drawable.ic_launcher_background, R.drawable.ic_launcher_background, R.drawable.ic_launcher_background};

        GridViewCustomItem adapter = new GridViewCustomItem(this, title, description, image);

        gridView.setAdapter(adapter);

        gridView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                String title = adapter.title[position];

                Toast.makeText(getApplicationContext(), title, Toast.LENGTH_SHORT).show();
            }
        });
    }
}
