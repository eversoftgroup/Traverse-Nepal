package com.eversoft.traversenepal;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.View;
import android.widget.ImageButton;
import android.widget.PopupMenu;

import com.eversoft.traversenepal.R;

public class nav_mypick_activity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.nav_mypick_activity);

        final ImageButton BtnMoreOption = findViewById(R.id.nav_my_pick_more_vert);



        setTitle("My Pick");

        BtnMoreOption.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                PopupMenu popupMenu = new PopupMenu(nav_mypick_activity.this, BtnMoreOption);
                //inflating xml file
                popupMenu.getMenuInflater().inflate(R.menu.my_pic_card_menu, popupMenu.getMenu());
                popupMenu.show();
            }
        });
    }
}
