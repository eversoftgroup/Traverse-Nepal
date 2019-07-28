package com.eversoft.traversenepal;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.text.InputType;
import android.util.Log;
import android.view.View;
import android.support.v4.view.GravityCompat;
import android.support.v7.app.ActionBarDrawerToggle;
import android.view.MenuItem;
import android.support.design.widget.NavigationView;
import android.support.v4.widget.DrawerLayout;

import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.widget.EditText;
import android.widget.HeaderViewListAdapter;
import android.widget.TextView;
import android.widget.Toast;

import com.eversoft.adapters.RecycleViewAdapter;
import com.eversoft.generalfeatures.nav_contactUs_activity;
import com.eversoft.models.home_model;
import com.eversoft.settings.nav_login_activity;
import com.eversoft.generalfeatures.nav_feedback_activity;
import com.eversoft.utils.Session;
import com.eversoft.visitnepal2020.nav_visitnepal2020_activity;
import com.eversoft.settings.nav_setting_activity;
import com.eversoft.generalfeatures.*;

import org.w3c.dom.Text;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {

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

        //horizontalScroll();
        session  = new Session(this);
        if(!session.getUsername().equals("") && !session.getPassword().equals("")){
            navigationView.getMenu().findItem(R.id.nav_login_signup).setVisible(false);
            navigationView.getMenu().findItem(R.id.nav_mypick).setVisible(true);
            navigationView.getMenu().findItem(R.id.nav_profile).setVisible(true);
            navigationView.getMenu().findItem(R.id.nav_logout).setVisible(true);

            View headerView = navigationView.getHeaderView(0);
            TextView nav_username = headerView.findViewById(R.id.nav_header_username);
            nav_username.setText("Welcome, "+ session.getUsername());
        }
    }

    public void horizontalScroll(){
        ArrayList<home_model> items = new ArrayList<>();
        RecycleViewAdapter viewAdapter = new RecycleViewAdapter(this,items);
        RecyclerView recyclerView = findViewById(R.id.home_recycleView);
        recyclerView.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false));
        recyclerView.setAdapter(viewAdapter);

        for(int i=0; i < 4; i++){
            items.add(new home_model(R.drawable.ic_launcher_background, "Title " + i));
            viewAdapter.notifyDataSetChanged();
        }
    }

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
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
        } else if (id == R.id.nav_mypick) {
            Intent myIntent = new Intent(MainActivity.this, nav_mypick_activity.class);
            MainActivity.this.startActivity(myIntent);
        }  else if (id == R.id.nav_profile) {
            Toast.makeText(MainActivity.this, "Open profile activity", Toast.LENGTH_SHORT).show();
        }else if (id == R.id.nav_login_signup) {
            Intent intent = new Intent(MainActivity.this, nav_login_activity.class);
            MainActivity.this.startActivity(intent);
        } else if (id == R.id.nav_aboutus) {
            Intent intent = new Intent(MainActivity.this, nav_contactUs_activity.class);
            MainActivity.this.startActivity(intent);
        } else if(id == R.id.nav_feedback) {
            Intent intent = new Intent(MainActivity.this, nav_feedback_activity.class);
            MainActivity.this.startActivity(intent);
        } else if(id == R.id.nav_visitnepal2020) {
            Intent intent = new Intent(MainActivity.this, nav_visitnepal2020_activity.class);
            MainActivity.this.startActivity(intent);
        } else if(id == R.id.nav_help) {
            Intent intent = new Intent(MainActivity.this, nav_help_activity.class);
            MainActivity.this.startActivity(intent);
        } else if(id == R.id.nav_setting) {
            Intent intent = new Intent(MainActivity.this, nav_setting_activity.class);
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


            DrawerLayout drawer = findViewById(R.id.drawer_layout);
            drawer.closeDrawer(GravityCompat.START);
            return true;
        }

        public void logout(){
            session.setUsername("");
            session.setPassword("");
            Toast.makeText(MainActivity.this, "You are logged out", Toast.LENGTH_SHORT).show();
            finish();
            startActivity(getIntent());
        }
    }
