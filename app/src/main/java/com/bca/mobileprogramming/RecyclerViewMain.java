package com.bca.mobileprogramming;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

public class RecyclerViewMain extends AppCompatActivity {
    RecyclerView recyclerView;
    RecyclerView.Adapter adapter;
    RecyclerView.LayoutManager layoutManager;

    @Override
    protected void onCreate(Bundle b) {
        super.onCreate(b);

        setContentView(R.layout.recycler_view_main);

        recyclerView = findViewById(R.id.main_recycler_list);

        String[] title = {"Title 1", "Title 1", "Title 1", "Title 1", "Title 1", "Title 1",
                "Title 1", "Title 1", "Title 1", "Title 1", "Title 1", "Title 1", "Title 1",
                "Title 1", "Title 1", "Title 1", "Title 1"};

        String[] description = {"This is description 1.", "This is description 1.", "This is description 1.", "This is description 1.", "This is description 1.", "This is description 1.",
                "This is description 1.", "This is description 1.", "This is description 1.", "This is description 1.", "This is description 1.", "This is description 1.", "This is description 1.",
                "This is description 1.", "This is description 1.", "This is description 1.", "This is description 1."};

        int[] image = {R.drawable.ic_launcher_background, R.drawable.ic_launcher_background, R.drawable.ic_launcher_background, R.drawable.ic_launcher_background, R.drawable.ic_launcher_background, R.drawable.ic_launcher_background,
                R.drawable.ic_launcher_background, R.drawable.ic_launcher_background, R.drawable.ic_launcher_background, R.drawable.ic_launcher_background, R.drawable.ic_launcher_background, R.drawable.ic_launcher_background, R.drawable.ic_launcher_background,
                R.drawable.ic_launcher_background, R.drawable.ic_launcher_background, R.drawable.ic_launcher_background, R.drawable.ic_launcher_background};

        layoutManager = new LinearLayoutManager(this);

        recyclerView.setLayoutManager(layoutManager);

        adapter = new CustomRecyclerViewAdapter(this, title, description, image);

        recyclerView.setAdapter(adapter);
    }
}
