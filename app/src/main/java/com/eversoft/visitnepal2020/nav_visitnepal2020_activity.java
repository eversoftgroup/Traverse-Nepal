package com.eversoft.visitnepal2020;

import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.webkit.WebSettings;
import android.webkit.WebView;

import com.eversoft.adapters.FragmentAdapter;
import com.eversoft.traversenepal.R;

public class nav_visitnepal2020_activity extends AppCompatActivity {

    TabLayout tabLayout;
    WebView mywebview;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.nav_visitnepal2020_activity);
        setTitle("#VisitNepal2020");

        tabLayout = findViewById(R.id.tabLayout);

        ViewPager viewPager = findViewById(R.id.viewPager);
        FragmentAdapter adapter = new FragmentAdapter(this, getSupportFragmentManager());
        viewPager.setAdapter(adapter);
        tabLayout.setupWithViewPager(viewPager);

        mywebview = findViewById(R.id.webview_visitnepal2020);

        mywebview.loadUrl("https://500px.com/search?submit=Submit&q=nepal&type=photos");
        WebSettings webSettings = mywebview.getSettings();
        webSettings.setBuiltInZoomControls(true);
        webSettings.setJavaScriptEnabled(true);

    }

}
