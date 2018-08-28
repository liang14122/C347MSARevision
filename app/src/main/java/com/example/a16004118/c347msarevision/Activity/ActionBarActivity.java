package com.example.a16004118.c347msarevision.Activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

import com.example.a16004118.c347msarevision.R;

public class ActionBarActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_action_bar);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {

        getMenuInflater().inflate(R.menu.action_bar_menu, menu);

        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        switch (item.getItemId()) {
            case R.id.action_compose:
                Toast.makeText(ActionBarActivity.this, "Compose", Toast.LENGTH_SHORT).show();
                break;
            case R.id.action_call:
                Toast.makeText(ActionBarActivity.this, "Call", Toast.LENGTH_SHORT).show();
                break;
            case R.id.action_delete:
                Toast.makeText(ActionBarActivity.this, "Delete", Toast.LENGTH_SHORT).show();
                break;
            case R.id.action_search:
                Toast.makeText(ActionBarActivity.this, "Search", Toast.LENGTH_SHORT).show();
                break;
            default:
                break;
        }

        return super.onOptionsItemSelected(item);
    }
}
