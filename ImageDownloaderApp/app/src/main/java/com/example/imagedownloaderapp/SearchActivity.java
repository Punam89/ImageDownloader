package com.example.imagedownloaderapp;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class SearchActivity extends AppCompatActivity {

    ListView listView;
    String search_item;

    ArrayList<String> listitem;
    ArrayAdapter adapter;

    String[] ListElements = new String[] {
            "Tiger",
            "flowers",
            "Rose",
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search);
        listView=findViewById(R.id.list1);

        search_item=getIntent().getStringExtra("value");
        listitem = new ArrayList<>();
        final List<String> list =  new ArrayList<>(Arrays.asList(ListElements));
        list.add(search_item);
        final ArrayAdapter<String> adapter = new ArrayAdapter<>(this, R.layout.row, list);
        listView.setAdapter(adapter);
        adapter.notifyDataSetChanged();


    }


}