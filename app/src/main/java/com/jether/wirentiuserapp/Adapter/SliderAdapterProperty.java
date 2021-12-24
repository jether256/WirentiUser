package com.jether.wirentiuserapp.Adapter;


import android.content.Context;
import android.net.Uri;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;


import com.jether.wirentiuserapp.Model.ImageSliderModel;
import com.jether.wirentiuserapp.R;
import com.smarteist.autoimageslider.SliderViewAdapter;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.List;

public class SliderAdapterProperty extends SliderViewAdapter<SliderAdapterProperty.SliderAdapterVH1> {
    private Context context;
    private List<ImageSliderModel> mSliderItems = new ArrayList<>();

    public SliderAdapterProperty(Context context,List<ImageSliderModel> mSliderItems) {
        this.context = context;
        this.mSliderItems = mSliderItems;
    }


    @Override
    public SliderAdapterVH1 onCreateViewHolder(ViewGroup parent) {
        View inflate = LayoutInflater.from(parent.getContext()).inflate(R.layout.slider_property ,null);
        return new SliderAdapterVH1(inflate);
    }

    @Override
    public void onBindViewHolder(SliderAdapterProperty.SliderAdapterVH1 viewHolder, final int position) {


        viewHolder.imageView.setImageResource(mSliderItems.get(position).getImage());
        //Picasso.get().load((Uri) mSliderItems).placeholder(R.drawable.ic_b_house_24).into(i);

      
    }

    @Override
    public int getCount() {
        //slider view count could be dynamic size
        return mSliderItems.size();
    }

    class SliderAdapterVH1 extends SliderViewAdapter.ViewHolder {

        ImageView imageView;
        public SliderAdapterVH1(View itemView) {
            super(itemView);

            imageView=itemView.findViewById(R.id.imageView1);
        }
    }

}
