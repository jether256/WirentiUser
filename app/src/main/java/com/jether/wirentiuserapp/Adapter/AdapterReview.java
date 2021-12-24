package com.jether.wirentiuserapp.Adapter;


import android.content.Context;
import android.text.format.DateFormat;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;


import com.jether.wirentiuserapp.Model.ModelReview;
import com.jether.wirentiuserapp.R;


import java.util.ArrayList;
import java.util.Calendar;
import java.util.Locale;

public class AdapterReview extends RecyclerView.Adapter<AdapterReview.PropertyViewHolder> {

    private ArrayList<ModelReview> reviews;
    Context context;

    public AdapterReview(ArrayList<ModelReview> reviews, Context context) {
        this.reviews = reviews;
        this.context = context;
    }



    @NonNull
    @Override
    public PropertyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.review,parent,false);
        return new PropertyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull PropertyViewHolder holder, int position) {

        ModelReview modelReview=reviews.get(position);
        String name3=modelReview.getFullName();
        String remark=modelReview.getUserRemark();
        String date=modelReview.getPostingDate();

        //convert the time stamp to dd/MM/yyyy hh:mm am/pm

        Calendar calendar= Calendar.getInstance(Locale.getDefault());
        calendar.setTimeInMillis(Long.parseLong(date));

        String pTime= DateFormat.format("dd/MM/yyyy hh:mm aa",calendar).toString();


        holder.name.setText(name3);
        holder.date.setText(pTime);
        holder.review.setText(remark);
    }

    @Override
    public int getItemCount() {
        return reviews.size();
    }

    public static class PropertyViewHolder extends RecyclerView.ViewHolder{

        TextView count,name,date,review;

        public PropertyViewHolder(@NonNull View itemView) {
            super(itemView);
            count= itemView.findViewById(R.id.textView24);
            name= itemView.findViewById(R.id.textView25);
            date= itemView.findViewById(R.id.textView26);
            review= itemView.findViewById(R.id.textView27);
        }
    }
}
