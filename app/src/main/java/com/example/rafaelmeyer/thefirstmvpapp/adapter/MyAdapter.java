package com.example.rafaelmeyer.thefirstmvpapp.adapter;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.rafaelmeyer.thefirstmvpapp.R;
import com.example.rafaelmeyer.thefirstmvpapp.model.Person;

import java.util.List;

/**
 * Created by rafael.meyer on 10/14/16.
 */
public class MyAdapter extends RecyclerView.Adapter<MyAdapter.ViewHolder> {

    private List<Person> personList;

    public MyAdapter(List<Person> personList) {
        this.personList = personList;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item, parent, false);
        ViewHolder viewHolder = new ViewHolder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        holder.textViewNameItem.setText(personList.get(position).getName());
        holder.textViewCPFItem.setText(personList.get(position).getCpf());
    }

    @Override
    public int getItemCount() {
        return personList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView textViewNameItem;
        TextView textViewCPFItem;

        public ViewHolder(View itemView) {
            super(itemView);

            textViewNameItem = (TextView) itemView.findViewById(R.id.textViewNameItem);
            textViewCPFItem = (TextView) itemView.findViewById(R.id.textViewCPFItem);
        }
    }
}
