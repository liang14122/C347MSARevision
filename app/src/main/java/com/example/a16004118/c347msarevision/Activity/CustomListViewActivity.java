package com.example.a16004118.c347msarevision.Activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;

import com.example.a16004118.c347msarevision.Adapter.CustomLVAdapter;
import com.example.a16004118.c347msarevision.Object.CustomLVItem;
import com.example.a16004118.c347msarevision.R;

import java.util.ArrayList;

public class CustomListViewActivity extends AppCompatActivity {

    private ListView lv;
    private CustomLVAdapter adapter;
    private ArrayList<CustomLVItem> alItem = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_custom_list_view);

        lv = findViewById(R.id.lv);
        adapter = new CustomLVAdapter(CustomListViewActivity.this, R.layout.custom_lv_row, alItem);
        lv.setAdapter(adapter);

        for (int i = 0; i < 5; i++){
            CustomLVItem item = new CustomLVItem("Title "+i, "Description "+i);
            alItem.add(item);
        }

        adapter.notifyDataSetChanged();
    }
}
