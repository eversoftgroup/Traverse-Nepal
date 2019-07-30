package com.eversoft.adapters;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.app.FragmentStatePagerAdapter;

import com.eversoft.fragments.visitnepal_photo;
import com.eversoft.fragments.visitnepal_video;

import java.util.ArrayList;
import java.util.List;

public class visit2020_tab_adapter extends FragmentPagerAdapter {
    private final List<Fragment>  fragmentList= new ArrayList<>();
    private final List<String> fragmentTitle = new ArrayList<>();


    public visit2020_tab_adapter(FragmentManager fm){
        super(fm);
    }
    @Override
    public Fragment getItem(int i) {
        return fragmentList.get(i);
    }

    @Override
    public int getCount() {
        return fragmentTitle.size();
    }

    public void AddFragment(Fragment fragment, String Title){
        fragmentList.add(fragment);
        fragmentTitle.add(Title);
    }
}
