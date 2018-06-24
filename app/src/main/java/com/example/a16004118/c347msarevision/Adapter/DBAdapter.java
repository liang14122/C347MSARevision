package com.example.a16004118.c347msarevision.Adapter;

import android.annotation.SuppressLint;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.a16004118.c347msarevision.Object.CustomLVItem;
import com.example.a16004118.c347msarevision.Object.DBItem;
import com.example.a16004118.c347msarevision.R;

import java.util.ArrayList;

public class DBAdapter extends ArrayAdapter {

    Context parent_context;
    int layout_id;
    ArrayList<DBItem> itemList;

    public DBAdapter(Context context,
                           int resource,
                           ArrayList<DBItem> objects) {
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

        TextView tvName = rowView.findViewById(R.id.tvName);
        TextView tvId = rowView.findViewById(R.id.tvId);
        ImageView iv1 = rowView.findViewById(R.id.imageView1star);
        ImageView iv2 = rowView.findViewById(R.id.imageView2star);
        ImageView iv3 = rowView.findViewById(R.id.imageView3star);
        ImageView iv4 = rowView.findViewById(R.id.imageView4star);
        ImageView iv5 = rowView.findViewById(R.id.imageView5star);

        ArrayList<ImageView> ivList = new ArrayList<>();
        ivList.add(iv1);
        ivList.add(iv2);
        ivList.add(iv3);
        ivList.add(iv4);
        ivList.add(iv5);

        DBItem currentItem = itemList.get(position);

        tvName.setText(currentItem.getName());
        tvId.setText(currentItem.getId());
        for (int i = 0; i < currentItem.getStar(); i++){
            ivList.get(i).setImageResource(android.R.drawable.btn_star_big_on);
        }

        return rowView;
    }


}
