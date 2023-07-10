package com.bca.mobileprogramming;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.ArrayList;

public class ListViewAdapter extends ArrayAdapter<String> {
    Activity context;
    ArrayList<Integer> id;
    ArrayList<String> name;
    ArrayList<String> address;

    public ListViewAdapter(Activity context, ArrayList<Integer> id,
                           ArrayList<String> name, ArrayList<String> address) {
        super(context, R.layout.list_view_items, name);

        this.context = context;
        this.id = id;
        this.name = name;
        this.address = address;
    }

    public View getView(int position, View view, ViewGroup parent) {
        LayoutInflater inflater = context.getLayoutInflater();

        View rowView = inflater.inflate(R.layout.list_view_items, null, true);

        TextView txtId = rowView.findViewById(R.id.listViewTxtId);
        TextView txtName = rowView.findViewById(R.id.listViewTxtName);
        TextView txtAddress = rowView.findViewById(R.id.listViewTxtAddress);

        txtId.setText(id.get(position).toString());
        txtName.setText(name.get(position));
        txtAddress.setText(address.get(position));

        return rowView;
    }
}
