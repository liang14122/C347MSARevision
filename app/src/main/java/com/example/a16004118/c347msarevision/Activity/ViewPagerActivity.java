package com.example.a16004118.c347msarevision.Activity;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;

import com.example.a16004118.c347msarevision.Adapter.MyFragmentPagerAdapter;
import com.example.a16004118.c347msarevision.Fragment.ViewPagerFragment;
import com.example.a16004118.c347msarevision.R;

import java.util.ArrayList;
import java.util.Random;

public class ViewPagerActivity extends AppCompatActivity {

    private ViewPager vpContent;
    private static final String TAG = "ViewPagerActivity";
    private ArrayList<Fragment> al;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_pager);

        vpContent = findViewById(R.id.vpContent);
        al = new ArrayList<>();

        for (int i = 0; i < 66; i++){
            al.add(new ViewPagerFragment(i));
        }

        FragmentManager fm = getSupportFragmentManager();

        MyFragmentPagerAdapter adapter = new MyFragmentPagerAdapter(fm, al);

        vpContent.setAdapter(adapter);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {

        getMenuInflater().inflate(R.menu.view_pager_menu, menu);

        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        switch (item.getItemId()) {
            case R.id.action_previous:
                previousFrag();
                break;
            case R.id.action_random:
                randomFrag();
                break;
            case R.id.action_Next:
                nextFrag();
                break;
            default:
                break;
        }

        return super.onOptionsItemSelected(item);
    }

    private void previousFrag() {


        if (vpContent.getCurrentItem() > 0){
            int previousPage = vpContent.getCurrentItem() - 1;
            vpContent.setCurrentItem(previousPage, true);
        }

    }

    private void randomFrag() {

        Random random = new Random();
        int randomPage = random.nextInt(al.size());
        vpContent.setCurrentItem(randomPage, true);

    }

    private void nextFrag() {

        int max = al.size();
        if (vpContent.getCurrentItem() < max -1){
            int nextPage = vpContent.getCurrentItem() + 1;
            vpContent.setCurrentItem(nextPage, true);
        }

    }
}
