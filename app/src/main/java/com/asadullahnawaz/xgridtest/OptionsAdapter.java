package com.asadullahnawaz.xgridtest;

import android.content.Context;
import android.net.Uri;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.asadullahnawaz.xgridtest.OptionModel;
import com.asadullahnawaz.xgridtest.R;

import java.util.ArrayList;

public class OptionsAdapter extends RecyclerView.Adapter<OptionsAdapter.ViewHolder> {

    Context context;
    ArrayList<OptionModel> options;

    public OptionsAdapter(Context context, ArrayList<OptionModel> options) {
        this.context = context;
        this.options = options;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View v = LayoutInflater.from(context).inflate(R.layout.option_layout,parent,false);
        ViewHolder viewHolder = new ViewHolder(v);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {

        holder.name.setText(options.get(position).getName());
        holder.icon.setImageResource(options.get(position).getIcon());

    }

    @Override
    public int getItemCount() {
        return options.size();
    }

    public class ViewHolder extends  RecyclerView.ViewHolder{

        TextView name;
        ImageView icon;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            name = itemView.findViewById(R.id.option_name);
            icon = itemView.findViewById(R.id.option_icon);
        }
    }

}
