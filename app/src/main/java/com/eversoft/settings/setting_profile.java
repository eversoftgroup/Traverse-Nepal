package com.eversoft.settings;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;
import android.widget.Toast;

import com.eversoft.api.ApiUserService;
import com.eversoft.api.RetrofitClientInstance;
import com.eversoft.entities.User;
import com.eversoft.traversenepal.MainActivity;
import com.eversoft.traversenepal.R;
import com.eversoft.utils.Session;
import com.eversoft.utils.SharedPrefHelper;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class setting_profile extends AppCompatActivity {

    TextView full_name,nationality,dob,doc_type,doc_number,exp_date,role;
    SharedPrefHelper sharedPrefHelper;
    Session session;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.setting_profile);

        full_name = findViewById(R.id.profile_full_name);
        nationality = findViewById(R.id.profile_nationality);
        dob = findViewById(R.id.profile_dob);
        doc_type = findViewById(R.id.profile_doc_type);
        doc_number = findViewById(R.id.profile_doc_number);
        exp_date = findViewById(R.id.profile_exp_date);
        role = findViewById(R.id.profile_role);

        session = new Session(this);

        final int id = session.getUserId();
        final String key = session.getApiKey();
        String ipaddress = sharedPrefHelper.GetSharedStringData("ipaddress", this);

        RetrofitClientInstance.getRetrofitInstance(ipaddress).create(ApiUserService.class).getUser(id,key)
                .enqueue(new Callback<User>() {
                    @Override
                    public void onResponse(Call<User> call, Response<User> response) {
                        if(response.body() != null){

                            User user = response.body();

                            full_name.setText(user.getFirstName() + " " + user.getMiddleName() + " " + user.getLastName());
                            nationality.setText(user.getNationality());
                            dob.setText(user.getDateOfBirth());
                            if(user.getLoginInformation().getRoleId() == 1){
                                role.setText("Admin");
                            }else if(user.getLoginInformation().getRoleId() == 2){
                                role.setText("Tourist");
                            }else{
                                role.setText("");
                            }

                            if(user.getVisaInformation() != null){
                                doc_type.setText(user.getVisaInformation().getDocumentType());
                                doc_number.setText(user.getVisaInformation().getDocumentNumber());
                                exp_date.setText(user.getVisaInformation().getExpiryDate());
                            }else{
                                doc_type.setText("");
                                doc_number.setText("");
                                exp_date.setText("");
                            }
                        }else{
                            Toast.makeText(setting_profile.this, "User not found", Toast.LENGTH_LONG).show();
                            Intent intent = new Intent(setting_profile.this, MainActivity.class);
                            startActivity(intent);
                        }
                    }

                    @Override
                    public void onFailure(Call<User> call, Throwable t) {
                        Log.d("ErrorMessage: ", t.toString());
                        //Toast.makeText(setting_profile.this, "Error message: " + t.getMessage(), Toast.LENGTH_LONG).show();
                    }
                });
    }
}
