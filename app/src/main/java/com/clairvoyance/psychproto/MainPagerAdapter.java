package com.clairvoyance.psychproto;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;


class MainPagerAdapter extends FragmentPagerAdapter {

    private DataPack dataPack;

    MainPagerAdapter(FragmentManager fm, DataPack dataPack){
        super(fm);
        this.dataPack = dataPack;
    }

    @Override
    public Fragment getItem(int i) {
        if(i == 0){ // Clock Fragment
            return ClockFragment.newInstance(dataPack);
        }
        else{ // Times Fragment
            return TimesFragment.newInstance(dataPack);
        }
    }

    @Override
    public int getCount() {
        return 0;
    }
}
