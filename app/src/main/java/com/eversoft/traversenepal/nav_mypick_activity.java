package com.eversoft.traversenepal;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.View;
import android.widget.ImageButton;
import android.widget.PopupMenu;
import android.widget.TextView;

import com.eversoft.adapters.MyPickAdapter;
import com.eversoft.api.ApiItineraryService;
import com.eversoft.api.RetrofitClientInstance;
import com.eversoft.entities.Itinerary;
import com.eversoft.traversenepal.R;
import com.eversoft.utils.Session;
import com.eversoft.utils.SharedPrefHelper;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class nav_mypick_activity extends AppCompatActivity {

    Session session;
    SharedPrefHelper sharedPrefHelper;
    TextView mypick_data;

    private MyPickAdapter retrofitAdapter;
    private RecyclerView recyclerView;

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

        recyclerView = findViewById(R.id.recycler);


        mypick_data = findViewById(R.id.myPick_data);
        //Retrofit
        session = new Session(this);
        final String key = session.getApiKey();
        final Integer id = session.getUserId();
        String ipaddress = sharedPrefHelper.GetSharedStringData("ipaddress", this);

        RetrofitClientInstance.getRetrofitInstance(ipaddress).create(ApiItineraryService.class).getAllItinerary(id,key)
                .enqueue(new Callback<List<Itinerary>>() {
                    @Override
                    public void onResponse(Call<List<Itinerary>> call, Response<List<Itinerary>> response) {
                        if(response.body() != null){
                            List<Itinerary> itineraries = response.body();
                            Log.d("Lists" , itineraries.toString());

                            //writeRecycler(itineraries);
                            mypick_data.setText("");
                            for (Itinerary itinerary: itineraries){
                                String content = "";
                                content += "Name: " + itinerary.getName() + "\n";
                                content += "Allocate Budget: " + itinerary.getAllocatedBudget().toString() + "\n";
                                content += "Priority: " + itinerary.getPriorityID().toString() + "\n";
                                content += "Description: " + itinerary.getDescription() + "\n";
                                content += "-------------------\n";

                                mypick_data.append(content);
                            }
                        }else{
                            mypick_data.setText("No Data found");
                            mypick_data.setTextSize(18);
                        }
                    }

                    @Override
                    public void onFailure(Call<List<Itinerary>> call, Throwable t) {
                        Log.d("ErrorMessage: ", t.toString());
                    }
                });
    }

    private void writeRecycler(List<Itinerary> itineraries){
        try{
            ArrayList<Itinerary> modelRecyclerArrayList = new ArrayList<>();
            for (Itinerary itinerary : itineraries){
                Itinerary it = new Itinerary();
                it.setName(itinerary.getName());
                it.setAllocatedBudget(itinerary.getAllocatedBudget());
                it.setDescription(itinerary.getDescription());
                it.setPriorityID(itinerary.getPriorityID());

                modelRecyclerArrayList.add(it);
            }
            retrofitAdapter = new MyPickAdapter(this,modelRecyclerArrayList);
            recyclerView.setAdapter(retrofitAdapter);
            recyclerView.setLayoutManager(new LinearLayoutManager(getApplicationContext(), LinearLayoutManager.VERTICAL, false));
        }catch (Exception e) {
            e.printStackTrace();
        }
    }
}