package com.bca.mobileprogramming;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class ListViewMainCustom extends AppCompatActivity {
    ListView listView;

    @Override
    protected void onCreate(Bundle b) {
        super.onCreate(b);

        // The main layout which has list view widget.
        setContentView(R.layout.list_view_main);

        // The particular list view widget that is going to populate items.
        listView = findViewById(R.id.list_view);

        String[] title = {"Title 1", "Title 1", "Title 1", "Title 1", "Title 1", "Title 1",
                "Title 1", "Title 1", "Title 1", "Title 1", "Title 1", "Title 1", "Title 1",
                "Title 1", "Title 1", "Title 1", "Title 1"};

        String[] description = {"This is description 1.", "This is description 1.", "This is description 1.", "This is description 1.", "This is description 1.", "This is description 1.",
                "This is description 1.", "This is description 1.", "This is description 1.", "This is description 1.", "This is description 1.", "This is description 1.", "This is description 1.",
                "This is description 1.", "This is description 1.", "This is description 1.", "This is description 1."};

        int[] image = {R.drawable.ic_launcher_background, R.drawable.ic_launcher_background, R.drawable.ic_launcher_background, R.drawable.ic_launcher_background, R.drawable.ic_launcher_background, R.drawable.ic_launcher_background,
                R.drawable.ic_launcher_background, R.drawable.ic_launcher_background, R.drawable.ic_launcher_background, R.drawable.ic_launcher_background, R.drawable.ic_launcher_background, R.drawable.ic_launcher_background, R.drawable.ic_launcher_background,
                R.drawable.ic_launcher_background, R.drawable.ic_launcher_background, R.drawable.ic_launcher_background, R.drawable.ic_launcher_background};

        ListViewCustomItem adapter = new ListViewCustomItem(this, title, description, image);

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
