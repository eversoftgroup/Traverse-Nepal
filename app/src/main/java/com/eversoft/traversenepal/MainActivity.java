package com.eversoft.traversenepal;

import android.annotation.SuppressLint;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.widget.CardView;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.CardView;
import android.text.InputType;
import android.util.Log;
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
import android.widget.Toast;

import com.eversoft.adapters.Place_detail;
import com.eversoft.generalfeatures.nav_contactUs_activity;
import com.eversoft.generalfeatures.nav_help_activity;
import com.eversoft.services.nav_currencyconverter;
import com.eversoft.generalfeatures.nav_help_activity;

import static android.widget.ListPopupWindow.WRAP_CONTENT;

import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.widget.EditText;
import android.widget.HeaderViewListAdapter;
import android.widget.TextView;
import android.widget.Toast;

import android.annotation.SuppressLint;

import com.eversoft.adapters.RecycleViewAdapter;
import com.eversoft.adapters.mainActivity_toolbar_Adapter;
import com.eversoft.fragments.currencyconverter;
import com.eversoft.fragments.weather;
import com.eversoft.generalfeatures.nav_contactUs_activity;
import com.eversoft.models.home_model;
import com.eversoft.services.nav_About_us;
import com.eversoft.services.nav_currencyconverter;
import com.eversoft.settings.nav_login_activity;
import com.eversoft.generalfeatures.nav_feedback_activity;
import com.eversoft.settings.setting_profile;
import com.eversoft.utils.Session;
import com.eversoft.visitnepal2020.nav_visitnepal2020_activity;
import com.eversoft.settings.nav_setting_activity;
import com.eversoft.generalfeatures.*;

import org.w3c.dom.Text;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener, currencyconverter.OnFragmentInteractionListener, weather.OnFragmentInteractionListener {
    private Session session;
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

        session  = new Session(this);
        if(!session.getUsername().equals("")){
            navigationView.getMenu().findItem(R.id.nav_login_signup).setVisible(false);
            navigationView.getMenu().findItem(R.id.nav_mypick).setVisible(true);
            navigationView.getMenu().findItem(R.id.nav_profile).setVisible(true);
            navigationView.getMenu().findItem(R.id.nav_logout).setVisible(true);

            View headerView = navigationView.getHeaderView(0);
            TextView nav_username = headerView.findViewById(R.id.nav_header_username);
            nav_username.setText("Welcome, "+ session.getUsername());
        }
    }

    @Override
    public void onBackPressed() {

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        //getMenuInflater().inflate(R.menu.bottom_appbar_menu, menu);
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
            Intent intent = new Intent(MainActivity.this, nav_setting_activity.class);
            MainActivity.this.startActivity(intent);
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
        }  else if (id == R.id.nav_profile) {
            Intent myIntent = new Intent(MainActivity.this, setting_profile.class);
            MainActivity.this.startActivity(myIntent);
        }else if (id == R.id.nav_login_signup) {
            Intent intent = new Intent(MainActivity.this, nav_login_activity.class);
            MainActivity.this.startActivity(intent);
        } else if (id == R.id.nav_aboutus) {
            Intent intent = new Intent(MainActivity.this, nav_About_us.class);
            MainActivity.this.startActivity(intent);
        } else if(id == R.id.nav_feedback) {
            Intent intent = new Intent(MainActivity.this, nav_feedback_activity.class);
            MainActivity.this.startActivity(intent);
        } else if(id == R.id.nav_setting) {
            Intent intent = new Intent(MainActivity.this, nav_setting_activity.class);
            MainActivity.this.startActivity(intent);
        }else if(id == R.id.nav_currencyconverter) {
            Intent intent = new Intent(MainActivity.this, nav_currencyconverter.class);
            MainActivity.this.startActivity(intent);
        } else if (id == R.id.nav_share) {
            Intent shareIntent = new Intent();
            shareIntent.setAction(Intent.ACTION_SEND);
            shareIntent.putExtra(Intent.EXTRA_TEXT, "https://facebook.com/eversoftgroup");
            shareIntent.setType("text/plain");
            startActivity(Intent.createChooser(shareIntent, "share via "));
        } else if(id == R.id.nav_logout) {
            logout();
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


            DrawerLayout drawer = findViewById(R.id.drawer_layout);
            drawer.closeDrawer(GravityCompat.START);
            return true;
        }

    @Override
    public void onFragmentInteraction(Uri uri) {

    }
        public void logout(){
            session.setUsername("");
            session.setApiKey("");
            session.setUserId(-1);
            Toast.makeText(MainActivity.this, "You are logged out", Toast.LENGTH_SHORT).show();
            finish();
            startActivity(getIntent());
        }
}
