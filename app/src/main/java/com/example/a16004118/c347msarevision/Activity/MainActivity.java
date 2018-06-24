package com.example.a16004118.c347msarevision.Activity;

import android.content.Intent;
import android.os.Build;
import android.support.annotation.RequiresApi;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ExpandableListView;
import android.widget.Toast;

import com.example.a16004118.c347msarevision.Adapter.ExpandableListViewAdapter;
import com.example.a16004118.c347msarevision.R;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Objects;

public class MainActivity extends AppCompatActivity {

    private List<String> listHeader;
    private HashMap<String, List<String>> listDetail;

    private static final String TAG = "MainActivity";

    @RequiresApi(api = Build.VERSION_CODES.KITKAT)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Log.e(TAG, "Class Name: " + this.getClass().getName() );

        Objects.requireNonNull(getSupportActionBar()).setTitle("Overview");

        ExpandableListView lv = findViewById(R.id.lv);

        prepareDetail();

        ExpandableListViewAdapter listAdapter = new ExpandableListViewAdapter(this, listHeader, listDetail);

        lv.setAdapter(listAdapter);

        lv.setOnChildClickListener(new ExpandableListView.OnChildClickListener() {
            @Override
            public boolean onChildClick(ExpandableListView parent, View v, int groupPosition, int childPosition, long id) {
                Toast.makeText(
                        getApplicationContext(),
                        listHeader.get(groupPosition)
                                + " : "
                                + listDetail.get(
                                listHeader.get(groupPosition)).get(
                                childPosition), Toast.LENGTH_SHORT)
                        .show();
                String activityToStart = "";

                if (groupPosition == 3 || groupPosition == 4){
                    activityToStart = "com.example.a16004118.c347msarevision.Activity.DatabaseActivity";
                }else{
                    activityToStart = "com.example.a16004118.c347msarevision.Activity." + listDetail.get(
                            listHeader.get(groupPosition)).get(
                            childPosition) + "Activity";
                }



                try {
                    Class c = Class.forName(activityToStart);
                    Intent intent = new Intent();
                    intent.setClassName(getApplicationContext(),activityToStart);
                    startActivity(intent);
                } catch (ClassNotFoundException ignored) {
                    Log.e(TAG, "onChildClick: " + ignored.getLocalizedMessage() );
                }
                return false;
            }
        });

    }

    private void prepareDetail() {

        listHeader = new ArrayList<>();
        listDetail = new HashMap<>();

        for (int i = 1; i < 8; i ++){
            listHeader.add("P0" + i);
        }

        List<String> p01 = new ArrayList<>();
        p01.add("ScrollView");
        p01.add("RadioGroup");

        List<String> p02 = new ArrayList<>();
        p02.add("CustomListView");
        p02.add("ImageView");

        List<String> p03 = new ArrayList<>();
        p03.add("ExplicitIntent");
        p03.add("ImplicitIntent");
        p03.add("Serializable");

        List<String> p04 = new ArrayList<>();
        p04.add("SQLiteCreate");
        p04.add("SQLiteInsert");
        p04.add("SQLiteSelect");

        List<String> p05 = new ArrayList<>();
        p05.add("SQLiteUpdate");
        p05.add("SQLiteDelete");
        p05.add("SQLiteFilteredSelect");

        List<String> p06 = new ArrayList<>();
        p06.add("AlarmManager");
        p06.add("Notification");

        List<String> p07 = new ArrayList<>();
        p07.add("Fragment");
        p07.add("ContentProvider");

        listDetail.put(listHeader.get(0), p01);
        listDetail.put(listHeader.get(1), p02);
        listDetail.put(listHeader.get(2), p03);
        listDetail.put(listHeader.get(3), p04);
        listDetail.put(listHeader.get(4), p05);
        listDetail.put(listHeader.get(5), p06);
        listDetail.put(listHeader.get(6), p07);// Header, Child data

    }
}