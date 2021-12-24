package com.jether.wirentiuserapp.Adapter;


import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;


import com.jether.wirentiuserapp.Model.StaticRvModel;
import com.jether.wirentiuserapp.R;


import java.util.ArrayList;

public class AdapterRv extends RecyclerView.Adapter<AdapterRv.StaticRvViewHolder> {

    private ArrayList<StaticRvModel> Items;

    int row_index=1;

    public AdapterRv(ArrayList<StaticRvModel> Items) {
        this.Items=Items;
    }


    @NonNull
    @Override
    public StaticRvViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.static_rv,parent,false);
        StaticRvViewHolder staticRvViewHolder= new StaticRvViewHolder(view);
        return staticRvViewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull StaticRvViewHolder holder, int position) {

        StaticRvModel current=Items.get(position);
        holder.image.setImageResource(current.getImage());
        holder.text.setText(current.getText());

        holder.linear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                row_index=position;
                notifyDataSetChanged();

            }
        });

        if(row_index == position){
            holder.linear.setBackgroundResource(R.drawable.static_rv_bg);
        }else{
            holder.linear.setBackgroundResource(R.drawable.static_rv_selected_bg);
        }

    }

    @Override
    public int getItemCount() {
        return Items.size();
    }

    public static class StaticRvViewHolder extends RecyclerView.ViewHolder {
        ImageView image;
        TextView text;
        LinearLayout linear;

        public StaticRvViewHolder(@NonNull View itemView) {
            super(itemView);

            image = itemView.findViewById(R.id.image);
            text = itemView.findViewById(R.id.text);
            linear= itemView.findViewById(R.id.linear);
        }

    }
}
