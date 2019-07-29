package com.eversoft.generalfeatures;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.LinearLayout;

import com.eversoft.ViewObjects.Help_List_Item;
import com.eversoft.adapters.help_activity_list_adapter;
import com.eversoft.traversenepal.R;




public class nav_help_activity extends AppCompatActivity {

    Help_List_Item[] listArr = new Help_List_Item[]{

            new Help_List_Item("Question 1", "Answer 1"),
            new Help_List_Item("Question 2", "Answer 2"),

            new Help_List_Item("Question 3", "Answer 1"),

            new Help_List_Item("Question 4", "Answer 1"),

            new Help_List_Item("Question 5", "Answer 1"),

            new Help_List_Item("Question 6", "Answer 1")
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_nav_help_activity);
        RecyclerView recyclerView = findViewById(R.id.nav_help_recycleView);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(new help_activity_list_adapter(listArr));


    }
}
