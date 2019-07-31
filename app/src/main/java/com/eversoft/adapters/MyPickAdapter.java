package com.eversoft.adapters;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.eversoft.entities.Itinerary;
import com.eversoft.traversenepal.R;

import java.util.ArrayList;

public class MyPickAdapter extends RecyclerView.Adapter<MyPickAdapter.MyViewHolder>{

    private LayoutInflater inflater;
    private ArrayList<Itinerary> dataModelArrayList;

    public MyPickAdapter(Context ctx, ArrayList<Itinerary> dataModelArrayList){
        inflater = LayoutInflater.from(ctx);
        this.dataModelArrayList = dataModelArrayList;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int i) {
        View view = inflater.inflate(R.layout.mypick_recycle, parent, false);
        MyViewHolder holder = new MyViewHolder(view);
        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        holder.myPick_name.setText(dataModelArrayList.get(position).getName());
        holder.myPick_allocatedBudget.setText(dataModelArrayList.get(position).getAllocatedBudget().toString());
        holder.myPick_description.setText(dataModelArrayList.get(position).getDescription());
        holder.myPick_priority.setText(dataModelArrayList.get(position).getPriorityID());
    }

    @Override
    public int getItemCount() {
        return dataModelArrayList.size();
    }

    class MyViewHolder extends RecyclerView.ViewHolder{

        TextView myPick_name, myPick_allocatedBudget, myPick_description,myPick_priority;

        public MyViewHolder(View itemView) {
            super(itemView);

            myPick_name = (TextView) itemView.findViewById(R.id.myPick_name);
            myPick_allocatedBudget = (TextView) itemView.findViewById(R.id.myPick_allocatedBudget);
            myPick_description = (TextView) itemView.findViewById(R.id.myPick_description);
            myPick_priority = (TextView) itemView.findViewById(R.id.myPick_priority);
        }
    }

}
