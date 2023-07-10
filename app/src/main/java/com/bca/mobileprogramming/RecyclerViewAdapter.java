package com.bca.mobileprogramming;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class RecyclerViewAdapter extends RecyclerView.Adapter<RecyclerViewAdapter.ViewHolder> {
    Activity context;
    ArrayList<DataModel> data;

    public RecyclerViewAdapter(Activity context, ArrayList<DataModel> data) {
        this.context = context;
        this.data = data;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(context);

        View listItem = layoutInflater.inflate(R.layout.list_view_items, parent, false);

        ViewHolder viewHolder = new ViewHolder(listItem);

        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        final DataModel current = data.get(position);

        holder.id.setText(Integer.toString(current.getId()));
        holder.name.setText(current.getName());
        holder.address.setText(current.getAddress());
    }

    @Override
    public int getItemCount() {
        return data.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        TextView id, name, address;

        public ViewHolder(View itemView) {
            super(itemView);

            id = itemView.findViewById(R.id.listViewTxtId);
            name = itemView.findViewById(R.id.listViewTxtName);
            address = itemView.findViewById(R.id.listViewTxtAddress);
        }
    }
}
