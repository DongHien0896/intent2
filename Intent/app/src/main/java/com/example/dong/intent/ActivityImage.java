package com.example.dong.intent;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class ActivityImage extends AppCompatActivity {

    private RecyclerView mRecyclerview;
    private List<String> mListItem = new ArrayList<>();
    private AdapterImage mAdapterImage;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mRecyclerview = findViewById(R.id.recyclerview);
        mListItem = getIntent().getStringArrayListExtra(Constants.VALUE);
        mAdapterImage = new AdapterImage(this, mListItem);
        mRecyclerview.setHasFixedSize(true);
        mRecyclerview.setAdapter(mAdapterImage);
        mRecyclerview.setLayoutManager(new GridLayoutManager(this, Constants.SPAN_COUNT));
        mAdapterImage.notifyDataSetChanged();
    }
}