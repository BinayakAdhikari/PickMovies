package com.rent.blaze.pickmovies.Adapters;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.rent.blaze.pickmovies.Objects.CategoryObjects;
import com.rent.blaze.pickmovies.ViewHolders.CategoryViewHolder;
import com.rent.blaze.pickmovies.R;

import java.util.List;

/**
 * Created by blaze on 6/28/16.
 */
public class CategoryAdapter extends RecyclerView.Adapter<CategoryViewHolder> {
    private List<CategoryObjects> categorylist;
    private Context context;

    public CategoryAdapter(Context context, List<CategoryObjects> categorylist) {
        this.categorylist = categorylist;
        this.context = context;
    }

    @Override
    public CategoryViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View layoutView = LayoutInflater.from(parent.getContext()).inflate(R.layout.categorycard,null);
        CategoryViewHolder categoryViewHolder = new CategoryViewHolder(layoutView);
        return categoryViewHolder;
    }

    @Override
    public void onBindViewHolder(CategoryViewHolder holder, int position) {
        holder.getAdapterPosition();
        holder.imgCategoryCover.setImageResource(categorylist.get(position).getPhoto());

    }

    @Override
    public int getItemCount() {
        return categorylist.size() ;
    }
}
