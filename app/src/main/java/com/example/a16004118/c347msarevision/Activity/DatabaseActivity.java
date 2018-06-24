package com.example.a16004118.c347msarevision.Activity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.RadioButton;

import com.example.a16004118.c347msarevision.Adapter.DBAdapter;
import com.example.a16004118.c347msarevision.Helper.DBHelper;
import com.example.a16004118.c347msarevision.Object.DBItem;
import com.example.a16004118.c347msarevision.R;

import java.util.ArrayList;

public class DatabaseActivity extends AppCompatActivity {

    private ArrayList<DBItem> dbItemList = new ArrayList<>();
    private DBAdapter dbAdapter;
    private ListView lvDBItem;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_database);

        Button btnCreateRecord = findViewById(R.id.btnCreateRecord);
        Button btnGetRecords = findViewById(R.id.btnGetRecords);
        Button btnUpdateRecord = findViewById(R.id.btnUpdateRecord);
        Button btnDeleteRecord = findViewById(R.id.btnDeleteRecord);
        Button btnGetRecordsByStar = findViewById(R.id.btnGetRecordsByStar);

        lvDBItem = findViewById(R.id.lvDBItem);
        dbAdapter = new DBAdapter(DatabaseActivity.this, R.layout.db_row, dbItemList);
        lvDBItem.setAdapter(dbAdapter);

        DBHelper dbh = new DBHelper(getApplicationContext());
        dbItemList = new ArrayList<>();
        dbItemList.addAll(dbh.getAllDBItem());
        Log.e("DatabaseActivity", "getAllDBItem: " + dbItemList.size() );

        dbAdapter.notifyDataSetChanged();
        dbh.close();


        btnCreateRecord.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                final String name = "Yao Liang";
                int star = 3;

                DBHelper db = new DBHelper(getApplicationContext());
                db.insertDBItem(name, star);
                db.close();
            }
        });

        btnGetRecords.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                DBHelper dbh = new DBHelper(getApplicationContext());
                dbItemList = new ArrayList<>();
                dbItemList.addAll(dbh.getAllDBItem());
                Log.e("DatabaseActivity", "getAllDBItem: " + dbItemList.size() );

                dbAdapter.notifyDataSetChanged();
                dbh.close();

            }
        });

        btnUpdateRecord.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                int id = 1;
                int star = 5;
                String name = "New Name";

                DBItem newDBItem = new DBItem(id, name, star);

                DBHelper dbh = new DBHelper(DatabaseActivity.this);
                dbh.updateDBItem(newDBItem);
                dbh.close();

            }
        });

        btnGetRecordsByStar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                DBHelper dbh = new DBHelper(getApplicationContext());

                int star = 3;
                dbItemList.addAll(dbh.getAllDBItembyStars(star));

            }
        });

        btnDeleteRecord.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                int id = 1;

                DBHelper dbh = new DBHelper(DatabaseActivity.this);
                dbh.deleteDBItem(id);
                dbh.close();

            }
        });

        lvDBItem.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

            }
        });

        lvDBItem.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(AdapterView<?> parent, View view, int position, long id) {
                return false;
            }
        });
    }
}
