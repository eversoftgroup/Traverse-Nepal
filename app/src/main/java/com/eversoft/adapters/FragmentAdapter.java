package com.eversoft.adapters;

import android.content.Context;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import com.eversoft.fragments.fragment_photo;
import com.eversoft.fragments.fragment_video;
import com.eversoft.traversenepal.R;

public class FragmentAdapter extends FragmentPagerAdapter {
    private Context mContext;

    public FragmentAdapter(Context context, FragmentManager fm){
        super(fm);
        mContext = context;
    }


    @Override
    public Fragment getItem(int position) {
        if(position == 0) {
            return new fragment_photo();
        }else if(position == 1) {
            return new fragment_video();
        }
        return null;
    }

    @Override
    public int getCount() {
        return 2;
    }

    @Override
    public CharSequence getPageTitle(int position) {
        switch (position){
            case 0:
                return mContext.getString(R.string.visitNepal2020_tab1);
            case 1:
                return mContext.getString(R.string.visitNepal2020_tab2);
                default:
                    return null;
        }
    }
}
