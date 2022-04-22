package com.example.cs160cashew;

import java.util.List;
import androidx.recyclerview.widget.RecyclerView;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;


public class MyAdapter extends RecyclerView.Adapter<MyAdapter.ViewHolder> {
    private List<Budget> values;
    private int temp;

    // Provide a reference to the views for each data item
    // Complex data items may need more than one view per item, and
    // you provide access to all the views for a data item in a view holder
    public class ViewHolder extends RecyclerView.ViewHolder {
        // each data item is just a string in this case
        public TextView txtHeader;
        public TextView limit;
        public View layout;
        private ImageView icon;
        public ViewHolder(View v) {
            super(v);
            layout = v;
            txtHeader = (TextView) v.findViewById(R.id.firstLine);
            limit = (TextView) v.findViewById(R.id.value);
        }
    }




    public void remove(int position) {
        values.remove(position);
        notifyItemRemoved(position);
    }
    // Provide a suitable constructor (depends on the kind of dataset)
    public MyAdapter(List<Budget> myDataset) {
        values = myDataset;

    }
    // Create new views (invoked by the layout manager)
    @Override
    public MyAdapter.ViewHolder onCreateViewHolder(ViewGroup parent,
                                                   int viewType) {
        // create a new view
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View v = inflater.inflate(R.layout.recycler_layout, parent, false);
        // set the view's size, margins, paddings and layout parameters
        ViewHolder vh = new ViewHolder(v);
        return vh;
    }




    // Replace the contents of a view (invoked by the layout manager)
    @Override
    public void onBindViewHolder(ViewHolder holder, final int position) {
        // - get element from your dataset at this position
        // - replace the contents of the view with that element
        final String name = values.get(position).getName();
        final int lim = values.get(position).getLimit();
        final Budget budget = values.get(position);

        holder.txtHeader.setText(name);

        holder.limit.setText("$" + Integer.toString(lim));
        holder.itemView.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {


                Intent budgetClick = null;

                try{

                    temp = holder.getAdapterPosition();
                    budgetClick = new Intent(v.getContext(), BudgetPage.class);
                    budgetClick.putExtra("budgetItem", budget);
                    System.out.println(budget.getCategoryList());

                    ((Activity) holder.layout.getContext()).startActivityForResult(budgetClick, 222);


                }
                catch (Exception e) {

                    System.out.println(e);


                }

            }


        });

    }

    public void onActivityResult(int requestCode, int resultCode, Intent data) {
       Budget budget = data.getParcelableExtra("budgetItem");
       values.set(temp, budget);
    }

    // Return the size of your dataset (invoked by the layout manager)
    @Override
    public int getItemCount() {
        return values.size();
    }




}