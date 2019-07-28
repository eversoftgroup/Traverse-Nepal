package com.eversoft.settings;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.eversoft.traversenepal.R;

public class nav_login_activity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.nav_login_activity);

        Button BtnSignUp =  findViewById(R.id.login_btn_signup);
        BtnSignUp.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View view) {
                Intent intent =  new Intent(nav_login_activity.this, nav_signup_activity.class);
                nav_login_activity.this.startActivity(intent);
            }
        });

    }


}
