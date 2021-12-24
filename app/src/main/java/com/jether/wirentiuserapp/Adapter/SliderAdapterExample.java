package com.jether.wirentiuserapp.Adapter;


import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;


import com.jether.wirentiuserapp.Model.ImageSliderModel;
import com.jether.wirentiuserapp.R;
import com.smarteist.autoimageslider.SliderViewAdapter;

import java.util.ArrayList;
import java.util.List;

public class SliderAdapterExample extends
        SliderViewAdapter<SliderAdapterExample.SliderAdapterVH> {

    private Context context;
    private List<ImageSliderModel> mSliderItems = new ArrayList<>();

    public SliderAdapterExample(Context context,List<ImageSliderModel> mSliderItems) {
        this.context = context;
        this.mSliderItems = mSliderItems;
    }


    @Override
    public SliderAdapterVH onCreateViewHolder(ViewGroup parent) {
        View inflate = LayoutInflater.from(parent.getContext()).inflate(R.layout.slider_item_layout, null);
        return new SliderAdapterVH(inflate);
    }

    @Override
    public void onBindViewHolder(SliderAdapterVH viewHolder, final int position) {

        viewHolder.imageView.setImageResource(mSliderItems.get(position).getImage());
    }

    @Override
    public int getCount() {
        //slider view count could be dynamic size
        return mSliderItems.size();
    }

    class SliderAdapterVH extends SliderViewAdapter.ViewHolder {

      ImageView imageView;
        public SliderAdapterVH(View itemView) {
            super(itemView);

            imageView=itemView.findViewById(R.id.imageView);
        }
    }

}