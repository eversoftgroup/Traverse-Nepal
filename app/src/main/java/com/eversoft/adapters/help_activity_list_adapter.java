package com.eversoft.adapters;

import android.content.Context;
import android.media.Image;
import android.speech.tts.TextToSpeech;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.eversoft.ViewObjects.Help_List_Item;
import com.eversoft.traversenepal.R;

import org.w3c.dom.Text;

import java.util.Objects;

public class help_activity_list_adapter extends RecyclerView.Adapter<help_activity_list_adapter.help_activity_ListViewHolder> {

    private Help_List_Item[] list_items_arry;

    public help_activity_list_adapter(Help_List_Item[] listItem){
        list_items_arry = listItem;
    }
    @Override
    public help_activity_ListViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        LayoutInflater inflate =  LayoutInflater.from(viewGroup.getContext());
        View view = inflate.inflate(R.layout.help_activity_list_item, viewGroup, false);
        return new help_activity_ListViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull final help_activity_ListViewHolder help_activity_listViewHolder, final int i) {
        String title;
        String Answer;
        title = list_items_arry[i].getQuestion();
        Answer  = list_items_arry[i].getAnswer();
        LinearLayout linearLayout = help_activity_listViewHolder.linearLayout;
        final TextView AnswerView = help_activity_listViewHolder.txtAnswer;

        help_activity_listViewHolder.txtTitle.setText(title);
        AnswerView.setText(Answer);

        linearLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(AnswerView.getVisibility() == View.GONE){
                    AnswerView.setVisibility(View.VISIBLE);
                }
                else if(AnswerView.getVisibility() == View.VISIBLE)
                {
                    AnswerView.setVisibility(View.GONE);
                }

            }
        });
    }

    @Override
    public int getItemCount() {
        return list_items_arry.length;
    }

    public class help_activity_ListViewHolder extends RecyclerView.ViewHolder{
        private ImageView img;
        private TextView txtTitle;
        private LinearLayout linearLayout;
        private TextView txtAnswer;
        public help_activity_ListViewHolder(@NonNull View itemView) {
            super(itemView);
            img = itemView.findViewById(R.id.help_activity_List_ProfileImg);
            txtTitle = itemView.findViewById(R.id.help_activity_List_Question);
            txtAnswer = itemView.findViewById(R.id.help_activity_List_Answer);
            linearLayout = itemView.findViewById(R.id.recycleview_layout);
        }
    }
}
