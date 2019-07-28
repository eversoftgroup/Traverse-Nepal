package com.eversoft.visitnepal2020;

import android.net.Uri;
import android.support.design.widget.TabItem;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.eversoft.adapters.visit2020_tab_adapter;
import com.eversoft.fragments.visitnepal_photo;
import com.eversoft.fragments.visitnepal_video;
import com.eversoft.traversenepal.R;

public class nav_visitnepal2020_activity extends AppCompatActivity implements visitnepal_photo.OnFragmentInteractionListener,visitnepal_video.OnFragmentInteractionListener{



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.nav_visitnepal2020_activity);

        TabLayout visitBNepalTab = findViewById(R.id.visitnepal_tab);



        visitBNepalTab.addTab(visitBNepalTab.newTab().setText("Picture"));
        visitBNepalTab.addTab(visitBNepalTab.newTab().setText("Video"));
        visitBNepalTab.setTabGravity(TabLayout.GRAVITY_FILL);


        visitnepal_photo photofrag = new visitnepal_photo();
        visitnepal_video videoFrag = new visitnepal_video();
        //adding fragments
        ViewPager viewPager = findViewById(R.id.visitNepal_viewPager);
        visit2020_tab_adapter adapter = new visit2020_tab_adapter(getSupportFragmentManager());
        adapter.AddFragment(photofrag, "Photo");
        adapter.AddFragment(videoFrag, "Video");

        //setting up adapter
        viewPager.setAdapter(adapter);

        //joining tablyout with adapter
        visitBNepalTab.setupWithViewPager(viewPager) ;




    }


    @Override
    public void onFragmentInteraction(Uri uri) {

    }
}
