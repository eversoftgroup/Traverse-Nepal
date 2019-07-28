package com.eversoft.settings;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.eversoft.traversenepal.MainActivity;
import com.eversoft.traversenepal.R;
import com.eversoft.utils.Session;

public class nav_login_activity extends AppCompatActivity {

    private Session session;
    EditText usernameTx,passwordTx;
    Button button;


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

        usernameTx = findViewById(R.id.login_name);
        passwordTx = findViewById(R.id.login_password);
        button = findViewById(R.id.login_btn_login);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String username = usernameTx.getText().toString();
                String password = passwordTx.getText().toString();

                if(username.trim().equals("") && password.trim().equals("")){
                    Toast.makeText(nav_login_activity.this, "Insert username or password", Toast.LENGTH_SHORT).show();
                }else {
                    if (loginorregister(username, password)) {
                        Toast.makeText(nav_login_activity.this, "You are logged In", Toast.LENGTH_SHORT).show();
                        Intent intent = new Intent(nav_login_activity.this, MainActivity.class);
                        startActivity(intent);
                    }
                }
            }
        });

    }

    private boolean loginorregister(String username, String password){
        if(username.trim() != "" && password.trim() != ""){
            session = new Session(this);
            session.setUsername(username);
            session.setPassword(password);
        }
        return true;
    }
}
