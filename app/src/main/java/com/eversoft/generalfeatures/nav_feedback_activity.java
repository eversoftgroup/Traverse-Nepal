package com.eversoft.generalfeatures;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.RatingBar;
import android.widget.TextView;

import com.eversoft.traversenepal.R;

public class nav_feedback_activity extends AppCompatActivity {

    private RatingBar ratingBar;

    private TextView tvRateCount,tvRateMessage;

    private float ratedValue;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.nav_feedback_activity);

        ratingBar = findViewById(R.id.ratingBar);
        tvRateCount = findViewById(R.id.tvRateCount);
        tvRateMessage = findViewById(R.id.tvRateMessage);

        ratingBar.setOnRatingBarChangeListener(new RatingBar.OnRatingBarChangeListener() {
            @Override
            public void onRatingChanged(RatingBar ratingBar, float rating,
                                        boolean fromUser) {
                ratedValue = ratingBar.getRating();

                tvRateCount.setText("Your Rating : "  + ratedValue + "/5.");
                if(ratedValue<1){
                    tvRateMessage.setText("ohh ho...");
                }else if(ratedValue<2){
                    tvRateMessage.setText("Ok.");
                }else if(ratedValue<3){
                    tvRateMessage.setText("Not bad.");
                }else if(ratedValue<4){
                    tvRateMessage.setText("Nice");
                }else if(ratedValue<5){
                    tvRateMessage.setText("Very Nice");
                }else if(ratedValue==5){
                    tvRateMessage.setText("Thank you..!!!");
                }
            }
        });

    }
}
