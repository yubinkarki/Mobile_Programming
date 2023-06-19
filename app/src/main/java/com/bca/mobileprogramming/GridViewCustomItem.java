package com.bca.mobileprogramming;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

public class GridViewCustomItem extends ArrayAdapter<String> {
    Activity context;
    String[] title;
    String[] description;
    int[] image;

    public GridViewCustomItem(Activity context, String[] title, String[] description, int[] image) {
        super(context, R.layout.grid_view_item_custom, title);

        this.context = context;
        this.title = title;
        this.description = description;
        this.image = image;
    }

    public View getView(int position, View view, ViewGroup parent) {
        LayoutInflater inflater = context.getLayoutInflater();

        View rowView = inflater.inflate(R.layout.grid_view_item_custom, null, true);

        TextView titleText = rowView.findViewById(R.id.custom_grid_title);
        ImageView imageView = rowView.findViewById(R.id.custom_grid_android_image);
        TextView descriptionText = rowView.findViewById(R.id.custom_grid_description);

        titleText.setText(title[position]);
        imageView.setImageResource(image[position]);
        descriptionText.setText(description[position]);

        return rowView;
    }
}
