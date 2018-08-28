package com.example.a16004118.c347msarevision.Fragment;


import android.annotation.SuppressLint;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.a16004118.c347msarevision.R;
import com.squareup.picasso.Picasso;

import org.w3c.dom.Document;
import org.w3c.dom.NamedNodeMap;
import org.xml.sax.InputSource;

import java.io.StringReader;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

/**
 * A simple {@link Fragment} subclass.
 */
@SuppressLint("ValidFragment")
public class ViewPagerFragment extends Fragment {

    private int currentPosition;

    @SuppressLint("ValidFragment")
    public ViewPagerFragment(int position) {
        // Required empty public constructor
        currentPosition = position;
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        // Inflate the layout for this fragment

        final View view = inflater.inflate(R.layout.fragment_view_pager, container, false);

        TextView tvPosition = view.findViewById(R.id.tvPosition);

        tvPosition.setText(String.valueOf(currentPosition));

        return view;
    }

}
