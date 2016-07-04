package com.rent.blaze.pickmovies;

import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

/**
 * Created by blaze on 6/28/16.
 */
public class CategoryViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

    public ImageView imgCategoryCover;
    public TextView txtCategoryName;


    public CategoryViewHolder(View itemView) {
        super(itemView);
        itemView.setOnClickListener(this);
        imgCategoryCover = (ImageView) itemView.findViewById(R.id.categorycover);
        txtCategoryName = (TextView) itemView.findViewById(R.id.categoryname);
    }

    @Override
    public void onClick(View v) {

        Intent startMainActivity = new Intent(v.getContext(), MainActivity.class);
        v.getContext().startActivity(startMainActivity);

    }
}
