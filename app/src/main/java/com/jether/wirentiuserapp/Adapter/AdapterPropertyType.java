package com.jether.wirentiuserapp.Adapter;


import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Spinner;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;


import com.jether.wirentiuserapp.Model.ModelPropertyType;
import com.jether.wirentiuserapp.R;


import java.util.ArrayList;

public class AdapterPropertyType extends RecyclerView.Adapter<AdapterPropertyType.PropertyViewHolder>{

    private ArrayList<ModelPropertyType> propertiesType;
    Context context;

    public AdapterPropertyType(ArrayList<ModelPropertyType> propertiesType, Context context) {
        this.propertiesType = propertiesType;
        this.context = context;
    }

    @NonNull
    @Override
    public PropertyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.spiner_type,parent,false);
        return new PropertyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull PropertyViewHolder holder, int position) {
        ModelPropertyType modelPropertyType=propertiesType.get(position);
        String Spi=modelPropertyType.getPropertType();

        holder.textView.setText(Spi);

    }

    @Override
    public int getItemCount() {
        return propertiesType.size();
    }


    public static class PropertyViewHolder extends RecyclerView.ViewHolder{

        TextView textView;

        public PropertyViewHolder(@NonNull View itemView) {
            super(itemView);
            textView= itemView.findViewById(R.id.z);
        }
    }
}
