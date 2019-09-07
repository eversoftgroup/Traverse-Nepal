package io.github.traverse_nepal;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.os.Handler;
import android.preference.PreferenceManager;
import android.support.v7.app.AppCompatActivity;

import io.github.traverse_nepal.R;
import io.github.traverse_nepal.login.LoginActivity;

import static utils.Constants.USER_TOKEN;

public class SplashActivity extends AppCompatActivity {
    private SharedPreferences mSharedPreferences;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);

        // add bank info, sim info into sharedpreference...

        mSharedPreferences = PreferenceManager.getDefaultSharedPreferences(this);
        Intent i;
        if (mSharedPreferences.getString(USER_TOKEN, null) != null) {
            i = MainActivity.getStartIntent(SplashActivity.this);
        } else {
            i = new Intent(SplashActivity.this, Start_help.class);
//            i = LoginActivity.getStartIntent(SplashActivity.this);
        }

        // TODO :: check for the user_token here & redirect to corresponding class
        // If token is null -> LoginActivity, else MainActivity
        new Handler().postDelayed(() -> {
            startActivity(i);
            finish();
        }, 2000);
    }
}
