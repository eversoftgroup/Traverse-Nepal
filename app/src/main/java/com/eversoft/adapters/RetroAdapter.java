package com.eversoft.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.eversoft.entities.Question;
import com.eversoft.traversenepal.R;

import java.util.ArrayList;

public class RetroAdapter extends BaseAdapter {

    private Context context;
    private ArrayList<Question> dataModelArrayList;

    public RetroAdapter(Context context, ArrayList<Question> dataModelArrayList) {

        this.context = context;
        this.dataModelArrayList = dataModelArrayList;
    }

    @Override
    public int getViewTypeCount() {
        return getCount();
    }
    @Override
    public int getItemViewType(int position) {

        return position;
    }

    @Override
    public int getCount() {
        return dataModelArrayList.size();
    }

    @Override
    public Object getItem(int position) {
        return dataModelArrayList.get(position);
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder holder;

        if (convertView == null) {
            holder = new ViewHolder();
            LayoutInflater inflater = (LayoutInflater) context
                    .getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            convertView = inflater.inflate(R.layout.retro_lv_question, null, true);

            holder.tvname = (TextView) convertView.findViewById(R.id.question_question);
            holder.tvcountry = (TextView) convertView.findViewById(R.id.question_insert_date);
            holder.tvcity = (TextView) convertView.findViewById(R.id.question_votes);

            convertView.setTag(holder);
        }else {
            // the getTag returns the viewHolder object set as a tag to the view
            holder = (ViewHolder)convertView.getTag();
        }

        holder.tvname.setText("Name: "+dataModelArrayList.get(position).getQuestion());
        holder.tvcountry.setText("InsertDate: "+dataModelArrayList.get(position).getInsertDate());
        holder.tvcity.setText("Votes: "+dataModelArrayList.get(position).getVotes());

        return convertView;
    }

    private class ViewHolder {

        protected TextView tvname, tvcountry, tvcity;
        protected ImageView iv;
    }


}
