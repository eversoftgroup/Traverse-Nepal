package com.eversoft.settings;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.InputType;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.eversoft.generalfeatures.nav_feedback_activity;
import com.eversoft.traversenepal.MainActivity;
import com.eversoft.traversenepal.R;
import com.eversoft.utils.SharedPrefHelper;

public class nav_setting_activity extends AppCompatActivity {

    Button changeIP;
    TextView IPaddress;

    SharedPreferences myPreferences;
    SharedPreferences.Editor editor;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.nav_settings_activity);
        setTitle("Setting");

        IPaddress = findViewById(R.id.serverIPAddress);
        SharedPrefHelper sharedPrefHelper = new SharedPrefHelper();
        IPaddress.setText(sharedPrefHelper.GetSharedStringData("ipaddress", nav_setting_activity.this));

        changeIP = findViewById(R.id.setIPAddress);
        changeIP.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                setIPAddress();
            }
        });
    }

    private void setIPAddress() {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle("IP address of Server");

        // Set up the input
        final EditText input = new EditText(this);
        // Specify the type of input expected; this, for example, sets the input as a password, and will mask the text
        input.setInputType(InputType.TYPE_CLASS_TEXT | InputType.TYPE_TEXT_VARIATION_NORMAL);
        builder.setView(input);

        // Set up the buttons
        builder.setPositiveButton("OK", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                String ipaddress = input.getText().toString();
                if(!ipaddress.equals("")){
                    SharedPrefHelper sharedPrefHelper = new SharedPrefHelper();
                    sharedPrefHelper.SetSharedStringData("ipaddress", input.getText().toString(), nav_setting_activity.this);
                    Toast.makeText(nav_setting_activity.this, "Successfully changed IP address", Toast.LENGTH_SHORT).show();
                    finish();
                    startActivity(getIntent());
                    }
            }
        });
        builder.setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                dialog.cancel();
            }
        });

        builder.show();
    }
}
