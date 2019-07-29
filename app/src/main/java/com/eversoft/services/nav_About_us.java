package com.eversoft.services;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;

import com.eversoft.traversenepal.R;

public class nav_About_us extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_about_us);


        //for card 1
        LinearLayout cardlayout = findViewById(R.id.nav_aboutus_card1);
        final LinearLayout bodylayout = findViewById(R.id.nav_aboutus_card_body);

        cardlayout.setOnClickListener(new View.OnClickListener() {
            int i =0;
            @Override
            public void onClick(View view) {
                if(i==0){
                    bodylayout.setVisibility(View.VISIBLE);
                    i = 1;

                } else if (i==1){
                    bodylayout.setVisibility(View.GONE);
                    i = 0;
                }
            }
        });


        //for card2
        LinearLayout cardlayout2 = findViewById(R.id.nav_aboutus_card2);
        final LinearLayout bodyLayout2 = findViewById(R.id.nav_aboutus_card_body2);

        cardlayout2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if(bodyLayout2.getVisibility() == View.GONE){
                    bodyLayout2.setVisibility(View.VISIBLE);


                } else if (bodyLayout2.getVisibility() == View.VISIBLE){
                    bodyLayout2.setVisibility(View.GONE);
                }
            }

        });
    }
}
