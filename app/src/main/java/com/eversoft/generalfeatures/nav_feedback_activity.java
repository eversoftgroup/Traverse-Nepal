package com.eversoft.generalfeatures;

import android.content.Context;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.RatingBar;
import android.widget.TextView;

import com.eversoft.traversenepal.MainActivity;
import com.eversoft.utils.SharedPrefHelper;
import com.eversoft.traversenepal.R;

public class nav_feedback_activity extends AppCompatActivity {

    private RatingBar ratingBar;

    private TextView tvRateCount,tvRateMessage;

    private float ratedValue;

    SharedPreferences myPreferences;
    SharedPreferences.Editor editor;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.nav_feedback_activity);
        setTitle("Feedback");

        ratingBar = findViewById(R.id.ratingBar);
        tvRateCount = findViewById(R.id.tvRateCount);
        tvRateMessage = findViewById(R.id.tvRateMessage);

        SharedPrefHelper sharedPrefHelper = new SharedPrefHelper();
        ratingBar.setRating(sharedPrefHelper.GetSharedFloatData("feedback", nav_feedback_activity.this));

        ratingBar.setOnRatingBarChangeListener(new RatingBar.OnRatingBarChangeListener() {
            @Override
            public void onRatingChanged(RatingBar ratingBar, float rating,
                                        boolean fromUser) {
                SharedPrefHelper sharedPrefHelper = new SharedPrefHelper();
                sharedPrefHelper.SetSharedFloatData("feedback", rating, nav_feedback_activity.this);

                tvRateMessage.setText("Thank you for your feedback!");
            }
        });

    }
}
