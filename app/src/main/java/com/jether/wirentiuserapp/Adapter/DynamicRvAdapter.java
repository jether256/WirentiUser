package com.jether.wirentiuserapp.Adapter;



import android.app.Activity;
import android.graphics.text.LineBreaker;
import android.media.Image;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

;
import com.jether.wirentiuserapp.LoadMore;
import com.jether.wirentiuserapp.Model.DynamicRvModel;
import com.jether.wirentiuserapp.R;

import java.util.List;

class LoadingViewHolder extends RecyclerView.ViewHolder{


    public ProgressBar progressBar;

    public LoadingViewHolder(@NonNull View itemView) {
        super(itemView);

        progressBar=itemView.findViewById(R.id.progressBar);
    }
}

class ItemViewHolder extends RecyclerView.ViewHolder{


    public TextView name;

    public ItemViewHolder(@NonNull View itemView) {
        super(itemView);

        name=itemView.findViewById(R.id.textView6);

    }
}

public class DynamicRvAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    private final int VIEW_TYPE_ITEM=0,VIEW_TYPE_LOADING=1;

    LoadMore loadMore;
    boolean isLoading;
    Activity activity;
    List<DynamicRvModel> items;
    int visibleThreshhold=9;
    int lastVisibleItem,totalItemCount;

    public DynamicRvAdapter(RecyclerView recyclerView ,Activity activity, List<DynamicRvModel> items) {
        this.activity = activity;
        this.items = items;

        final LinearLayoutManager linearLayoutManager= (LinearLayoutManager) recyclerView.getLayoutManager();
        recyclerView.addOnScrollListener(new RecyclerView.OnScrollListener() {
            @Override
            public void onScrolled(@NonNull RecyclerView recyclerView, int dx, int dy) {
                super.onScrolled(recyclerView, dx, dy);

                totalItemCount=linearLayoutManager.getItemCount();
                lastVisibleItem=linearLayoutManager.findLastVisibleItemPosition();
                if(!isLoading && totalItemCount <= (lastVisibleItem=visibleThreshhold)){
                    if(loadMore != null)
                        loadMore.OnloadMore();
                    isLoading=true;
                }
            }
        });
    }

    @Override
    public int getItemViewType(int position) {
        return items.get(position) == null ? VIEW_TYPE_LOADING:VIEW_TYPE_ITEM;
    }

    public void setLoadMore(LoadMore loadMore){
        this.loadMore=loadMore;
    }


    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        if(viewType == VIEW_TYPE_ITEM){

            View view= LayoutInflater.from(activity).inflate(R.layout.dynamic_item,parent,false);
            return new LoadingViewHolder(view);
        }else if (viewType == VIEW_TYPE_LOADING){
            View view= LayoutInflater.from(activity).inflate(R.layout.dynamic_progress_bar,parent,false);
            return new LoadingViewHolder(view);
        }

        return null;
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {

        if (holder instanceof ItemViewHolder){
            DynamicRvModel item=items.get(position);
            ItemViewHolder viewHolder=(ItemViewHolder) holder;
            viewHolder.name.setText(items.get(position).getName());

        }

        else if(holder instanceof  LoadingViewHolder){
                LoadingViewHolder loadingViewHolder=(LoadingViewHolder) holder;
        }

    }

    @Override
    public int getItemCount() {
        return items.size();
    }

    public void setLoaded(){
        isLoading=false;
    }
}
