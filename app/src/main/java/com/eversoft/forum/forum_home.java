package com.eversoft.forum;

import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import com.eversoft.adapters.RetroAdapter;
import com.eversoft.api.ForumService;
import com.eversoft.api.RetrofitClientInstance;
import com.eversoft.entities.Question;
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

public class forum_home extends AppCompatActivity {

    String items[] = new String[] {"Apple", "Banana"};

    List<String> stringList = new ArrayList<>();

    Session session;
    SharedPrefHelper sharedPrefHelper;
    private RetroAdapter retroAdapter;
    private ListView listView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_forum_home);

        listView = findViewById(R.id.lv_1);
        FloatingActionButton floatingActionButton = findViewById(R.id.edit_forum_question);


        session  = new Session(this);

        if(!session.getUsername().equals("")){
            floatingActionButton.hide();
        }

        final String key = session.getApiKey();
        final Integer id = session.getUserId();

        String ipaddress = sharedPrefHelper.GetSharedStringData("ipaddress", this);
        getJSONResponse(ipaddress);

    }

    private void getJSONResponse(String ipaddress) {
        RetrofitClientInstance.getRetrofitInstance(ipaddress).create(ForumService.class).getAllQuestion()
                .enqueue(new Callback<List<Question>>() {
                    @Override
                    public void onResponse(Call<List<Question>> call, Response<List<Question>> response) {
                        if(response.body() != null) {

                            Log.i("Responsestring", response.body().toString());

                            String jsonresponse = response.body().toString();
                            writeListView(jsonresponse);
                        }
                    }

                    @Override
                    public void onFailure(Call<List<Question>> call, Throwable t) {
                        Toast.makeText(forum_home.this, "Question not found " + t.getMessage(), Toast.LENGTH_SHORT).show();
                    }
                });
    }

    private void writeListView(String response){
        try {
            JSONObject obj = new JSONObject(response);
            ArrayList<Question> modelListViewArrayList = new ArrayList<>();
            JSONArray dataArray = obj.getJSONArray(response);

            for (int i = 0; i < dataArray.length(); i++) {

                Question modelListView = new Question();
                JSONObject dataobj = dataArray.getJSONObject(i);

                modelListView.setQuestion(dataobj.getString("question"));
                modelListView.setInsertDate(dataobj.getString("insertDate"));
                modelListView.setVotes(dataobj.getInt("votes"));

                Log.d("Question", dataobj.getString("question"));

                modelListViewArrayList.add(modelListView);
            }

            retroAdapter = new RetroAdapter(this, modelListViewArrayList);
            listView.setAdapter(retroAdapter);
            } catch (Exception e) {
                e.printStackTrace();
            }
    }

}
