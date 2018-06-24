package com.example.a16004118.c347msarevision.Adapter;

import android.annotation.SuppressLint;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import com.example.a16004118.c347msarevision.Object.CustomLVItem;
import com.example.a16004118.c347msarevision.R;

import java.util.ArrayList;

public class CustomLVAdapter extends ArrayAdapter {

    Context parent_context;
    int layout_id;
    ArrayList<CustomLVItem> itemList;

    public CustomLVAdapter(Context context,
                       int resource,
                       ArrayList<CustomLVItem> objects) {
        super(context, resource, objects);
        parent_context = context;
        layout_id = resource;
        itemList = objects;
    }

    @SuppressLint("SetTextI18n")
    @Override
    public View getView(final int position, View convertView, ViewGroup parent) {

        View rowView = convertView;

        if (rowView == null) {
            LayoutInflater inflater = (LayoutInflater) parent_context
                    .getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            rowView = inflater.inflate(layout_id, parent, false);
        } else {
            rowView = convertView;
        }

        TextView tvTitle = rowView.findViewById(R.id.tvTitle);
        TextView tvDescription = rowView.findViewById(R.id.tvDescription);

        CustomLVItem currentItem = itemList.get(position);
        tvTitle.setText(currentItem.getTitle());
        tvDescription.setText(currentItem.getDescription());

        return rowView;
    }


}
