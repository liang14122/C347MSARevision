package com.example.a16004118.c347msarevision.Activity;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import com.example.a16004118.c347msarevision.Fragment.FirstFragment;
import com.example.a16004118.c347msarevision.Fragment.SecondFragment;
import com.example.a16004118.c347msarevision.R;

public class FragmentActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fragment);

        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();

        Fragment fragment1 = new FirstFragment();
        fragmentTransaction.replace(R.id.frame1, fragment1);

        Fragment fragment2 = new SecondFragment();
        fragmentTransaction.replace(R.id.frame2, fragment2);

        fragmentTransaction.commit();


    }
}
