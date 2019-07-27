package com.eversoft.adapters;

import android.content.Context;
import android.media.Image;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.eversoft.ViewObjects.Help_List_Item;
import com.eversoft.traversenepal.R;

import org.w3c.dom.Text;

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
    public void onBindViewHolder(@NonNull help_activity_ListViewHolder help_activity_listViewHolder, int i) {
        String title;
        title = list_items_arry[i].getQuestion();
        help_activity_listViewHolder.txtTitle.setText(title);
    }

    @Override
    public int getItemCount() {
        return list_items_arry.length;
    }

    public class help_activity_ListViewHolder extends RecyclerView.ViewHolder{
        private ImageView img;
        private TextView txtTitle;
        public help_activity_ListViewHolder(@NonNull View itemView) {
            super(itemView);
            img = itemView.findViewById(R.id.help_activity_List_ProfileImg);
            txtTitle = itemView.findViewById(R.id.help_activity_List_Question);
        }
    }
}
