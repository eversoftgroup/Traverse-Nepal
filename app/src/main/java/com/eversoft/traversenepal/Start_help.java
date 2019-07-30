package com.eversoft.traversenepal;

import android.content.Intent;
import android.net.Uri;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.eversoft.fragments.help_bank;
import com.eversoft.fragments.help_info;
import com.eversoft.fragments.help_sim;

public class Start_help extends FragmentActivity implements help_sim.OnFragmentInteractionListener,help_bank.OnFragmentInteractionListener, help_info.OnFragmentInteractionListener {


    private ViewPager viewPager;

    private PagerAdapter pagerAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_start_help);

        viewPager = findViewById(R.id.help_viewpager);
        pagerAdapter = new ScreenSliderPagerAdapter(getSupportFragmentManager());
        viewPager.setAdapter(pagerAdapter);

        final Button FinishBtn = findViewById(R.id.help_finish);

        Bundle bundle = new Bundle();
        bundle.putInt("id", viewPager.getCurrentItem());
        help_bank bnkFrag = new help_bank();
        bnkFrag.setArguments(bundle);


        viewPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int i, float v, int i1) {

            }

            @Override
            public void onPageSelected(int i) {
                //visible button finish if page is at  last
                if(Integer.valueOf(viewPager.getCurrentItem()) == 2){
                    FinishBtn.setVisibility(View.VISIBLE);
                } else {
                    FinishBtn.setVisibility(View.GONE);
                }

            }

            @Override
            public void onPageScrollStateChanged(int i) {

            }
        });

        FinishBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Start_help.this, MainActivity.class);
                startActivity(intent);
            }
        });

    }

    @Override
    public void onFragmentInteraction(Uri uri) {

    }
}

class ScreenSliderPagerAdapter extends FragmentStatePagerAdapter{


    public ScreenSliderPagerAdapter(FragmentManager fm){
        super(fm);
    }

    @Override
    public Fragment getItem(int i) {
        help_bank bankFrag = new help_bank();
        help_info infoFrag = new help_info();
        help_sim simFrag = new help_sim();

        if(i == 0){

            return infoFrag;


        } else if(i == 1)
        {
            return  simFrag;
        }   else if (i == 2)
        {

            return  bankFrag;
        }   else    {
            return null;
        }



    }

    @Override
    public int getCount() {
        return 3;
    }
}
