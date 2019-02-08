package com.clairvoyance.psychproto;

import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity {

    ViewPager mainViewPager;
    DataPack dataPack;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        dataPack = new DataPack();
        getLayoutData();
        setLayoutData();
    }

    void getLayoutData(){
        mainViewPager = findViewById(R.id.clock_times_pager);
    }

    void setLayoutData(){
        mainViewPager.setAdapter(new MainPagerAdapter(getSupportFragmentManager(), dataPack));
    }

}