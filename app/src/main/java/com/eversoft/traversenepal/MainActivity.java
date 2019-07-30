package com.eversoft.traversenepal;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.widget.CardView;
import android.view.View;
import android.support.v4.view.GravityCompat;
import android.support.v7.app.ActionBarDrawerToggle;
import android.view.MenuItem;
import android.support.design.widget.NavigationView;
import android.support.v4.widget.DrawerLayout;

import com.eversoft.adapters.mainActivity_toolbar_Adapter;
import com.eversoft.fragments.currencyconverter;
import com.eversoft.fragments.weather;
import com.eversoft.services.nav_About_us;

import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.widget.LinearLayout;

import com.eversoft.adapters.Place_detail;
import com.eversoft.generalfeatures.nav_contactUs_activity;
import com.eversoft.generalfeatures.nav_help_activity;
import com.eversoft.services.nav_currencyconverter;
import com.eversoft.services.nav_login_activity;
import com.eversoft.generalfeatures.nav_feedback_activity;
import com.eversoft.visitnepal2020.nav_visitnepal2020_activity;

import static android.widget.ListPopupWindow.WRAP_CONTENT;

public class MainActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener, currencyconverter.OnFragmentInteractionListener, weather.OnFragmentInteractionListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        FloatingActionButton fab = findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });
        DrawerLayout drawer = findViewById(R.id.drawer_layout);
        NavigationView navigationView = findViewById(R.id.nav_view);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();
        navigationView.setNavigationItemSelectedListener(this);

        //linearlayout clickable
        LinearLayout linearLayoutBtn = findViewById(R.id.linearlayoutBtn);
        linearLayoutBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, Place_detail.class);
                startActivity(intent);
            }
        });

        ViewPager toolbarViewPager = findViewById(R.id.activity_main_toolbar_viewPager);
        PagerAdapter pagerAdapter = new mainActivity_toolbar_Adapter(getSupportFragmentManager());

        toolbarViewPager.setAdapter(pagerAdapter);

        //cardview expandable
        /*@SuppressLint("WrongViewCast") final CardView expandableCardview = findViewById(R.id.expandablecard);
        expandableCardview.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                expandableCardview.setLayoutParams(new CardView.LayoutParams(CardView.LayoutParams.WRAP_CONTENT, 300));
            }
        });*/
    }

    @Override
    public void onBackPressed() {

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();

        if (id == R.id.nav_home) {
            Intent intent = new Intent(MainActivity.this, MainActivity.class);
            MainActivity.this.startActivity(intent);
        } else if (id == R.id.nav_mypick) {
            Intent myIntent = new Intent(MainActivity.this, nav_mypick_activity.class);
            MainActivity.this.startActivity(myIntent);
        }   else if (id == R.id.nav_login_signup) {
            Intent intent = new Intent(MainActivity.this, nav_login_activity.class);
            MainActivity.this.startActivity(intent);
        } else if (id == R.id.nav_aboutus) {
            Intent intent = new Intent(MainActivity.this, nav_About_us.class);
            MainActivity.this.startActivity(intent);
        } else if(id == R.id.nav_feedback) {
            Intent intent = new Intent(MainActivity.this, nav_feedback_activity.class);
            MainActivity.this.startActivity(intent);
        } else if (id == R.id.nav_share) {
            Intent shareIntent = new Intent();
            shareIntent.setAction(Intent.ACTION_SEND);
            shareIntent.putExtra(Intent.EXTRA_TEXT, "https://facebook.com/eversoftgroup");
            shareIntent.setType("text/plain");
            startActivity(Intent.createChooser(shareIntent, "share via "));
        }
        else if (id == R.id.nav_help) {
            Intent intent = new Intent(MainActivity.this, nav_help_activity.class);
            MainActivity.this.startActivity(intent);
        }else if (id == R.id.nav_visitnepal2020) {
            Intent intent = new Intent(MainActivity.this, nav_visitnepal2020_activity.class);
            MainActivity.this.startActivity(intent);
        }else if (id == R.id.nav_currencyconverter) {
            Intent intent = new Intent(MainActivity.this, nav_currencyconverter.class);
            MainActivity.this.startActivity(intent);
        }

            return true;
        }

    @Override
    public void onFragmentInteraction(Uri uri) {

    }
}
