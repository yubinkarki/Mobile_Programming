package com.bca.mobileprogramming;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class CustomRecyclerViewAdapter extends RecyclerView.Adapter<CustomRecyclerViewAdapter.ViewHolder> {
    Activity context;
    int[] image;
    String[] title;
    String[] description;

    public CustomRecyclerViewAdapter(Activity context, String[] title, String[] description, int[] image) {
        this.title = title;
        this.description = description;
        this.image = image;
        this.context = context;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(context);

        View listItem = layoutInflater.inflate(R.layout.list_view_item_custom, parent, false);

        return new ViewHolder(listItem);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.titleText.setText(title[position]);
        holder.descriptionText.setText(description[position]);
        holder.imageView.setImageResource(image[position]);
    }

    @Override
    public int getItemCount() {
        return title.length;
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        TextView titleText, descriptionText;
        ImageView imageView;

        public ViewHolder(View itemView) {
            super(itemView);

            titleText = itemView.findViewById(R.id.custom_list_item_title);
            descriptionText = itemView.findViewById(R.id.custom_list_item_description);
            imageView = itemView.findViewById(R.id.android_image);
        }
    }
}
