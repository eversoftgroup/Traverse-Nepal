package com.eversoft.settings;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.eversoft.api.ApiUserService;
import com.eversoft.api.RetrofitClientInstance;
import com.eversoft.entities.Message;
import com.eversoft.entities.User;
import com.eversoft.entities.UserLogin;
import com.eversoft.traversenepal.MainActivity;
import com.eversoft.traversenepal.R;
import com.eversoft.utils.Session;
import com.eversoft.utils.SharedPrefHelper;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class nav_login_activity extends AppCompatActivity {

    private Session session;
    private SharedPrefHelper sharedPrefHelper = new SharedPrefHelper();

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

        passwordTx.setText("");

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                final String username = usernameTx.getText().toString();
                final String password = passwordTx.getText().toString();

                if(username.trim().equals("") && password.trim().equals("")){
                    Toast.makeText(nav_login_activity.this, "Insert username or password", Toast.LENGTH_SHORT).show();
                }else {
                    loginorregister(username,password);
//                    if (loginorregister(username, password)) {
//                        Toast.makeText(nav_login_activity.this, "You are logged In", Toast.LENGTH_SHORT).show();
//                        Intent intent = new Intent(nav_login_activity.this, MainActivity.class);
//                        startActivity(intent);
//                    }
                }
            }
        });

    }

    private boolean loginorregister(String inputUsername, String inputPassword){

        final String username = inputUsername.trim().toString();
        final String password = inputPassword.trim().toString();
        sharedPrefHelper = new SharedPrefHelper();
        String ipaddress = sharedPrefHelper.GetSharedStringData("ipaddress", this);

        Log.d("AuthServiceCalled with:", username + " " + password);

        RetrofitClientInstance.getRetrofitInstance(ipaddress).create(ApiUserService.class).userLogin(username,password)
                .enqueue(new Callback<UserLogin>() {
                    @Override
                    public void onResponse(Call<UserLogin> call, Response<UserLogin> response) {
                        if(response.body() != null){
                            UserLogin userLogin = response.body();
                            userLogin.getEmail();
                            session = new Session(nav_login_activity.this);
                            session.setUsername(userLogin.getUsername());
                            session.setUserId(userLogin.getId());
                            session.setApiKey(userLogin.getApiKey());

                            Toast.makeText(nav_login_activity.this, "You are logged In", Toast.LENGTH_SHORT).show();
                            Intent intent = new Intent(nav_login_activity.this, MainActivity.class);
                            startActivity(intent);
                        }else{
                            Toast.makeText(nav_login_activity.this, "Username or password is wrong!", Toast.LENGTH_SHORT).show();
                        }
                    }

                    @Override
                    public void onFailure(Call<UserLogin> call, Throwable t) {
                        Toast.makeText(nav_login_activity.this, t.getMessage(), Toast.LENGTH_LONG).show();
                    }
                });
        return true;
    }
}
