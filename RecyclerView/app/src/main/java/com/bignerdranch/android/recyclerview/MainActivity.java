package com.bignerdranch.android.recyclerview;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

public class MainActivity extends AppCompatActivity {
    private RecyclerView mRecyclerView;
    private String s1[], s2[];
    private int imagesource[] = {R.drawable.dog_icon, R.drawable.dog_icon, R.drawable.dog_icon, R.drawable.dog_icon, R.drawable.dog_icon, R.drawable.dog_icon, R.drawable.dog_icon, R.drawable.dog_icon};
    MyOwnAdapter mMyOwnAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mRecyclerView = findViewById(R.id.myrecyclerview);

        s1 = getResources().getStringArray(R.array.pet_name);
        s2 = getResources().getStringArray(R.array.desc);

        mMyOwnAdapter = new MyOwnAdapter(this, s1, s2, imagesource);

        mRecyclerView.setAdapter(mMyOwnAdapter);
        mRecyclerView.setLayoutManager(new LinearLayoutManager(this));
    }
}
