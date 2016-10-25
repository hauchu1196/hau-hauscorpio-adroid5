package com.example.hau.homeworkss15_categories.viewholders;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;


import com.example.hau.homeworkss15_categories.R;
import com.example.hau.homeworkss15_categories.models.Category;
import com.example.hau.homeworkss15_categories.utils.Utils;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by Hau on 25/10/2016.
 */
public class CategoryViewHolder extends RecyclerView.ViewHolder {
    @BindView(R.id.tv_title)
    TextView tvTitle;
    @BindView(R.id.iv_background)
    ImageView ivBackground;

    public CategoryViewHolder(View itemView) {
        super(itemView);
        ButterKnife.bind(this, itemView);
    }

    public void bind(Category category) {
        tvTitle.setText(category.getTitle());
        ivBackground.setImageBitmap(category.getBitmap());
    }
}
