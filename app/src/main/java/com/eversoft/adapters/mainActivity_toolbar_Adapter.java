package com.eversoft.adapters;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;

import com.eversoft.fragments.currencyconverter;
import com.eversoft.fragments.weather;

public class mainActivity_toolbar_Adapter extends FragmentStatePagerAdapter {


    public mainActivity_toolbar_Adapter(FragmentManager fm) {
        super(fm);
    }

    @Override
    public Fragment getItem(int i) {
        if(i == 0){
            return new weather();
        } else if (i == 1){
            return new currencyconverter();
        }
        else return null;
    }

    @Override
    public int getCount() {
        return 2;
    }
}
