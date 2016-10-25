package com.example.hau.homeworkss15_categories.adapters;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.hau.homeworkss15_categories.R;
import com.example.hau.homeworkss15_categories.models.Category;
import com.example.hau.homeworkss15_categories.viewholders.CategoryViewHolder;

/**
 * Created by Hau on 25/10/2016.
 */
public class CategoryAdapter extends RecyclerView.Adapter<CategoryViewHolder> {
    @Override
    public CategoryViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        View view = layoutInflater.inflate(R.layout.item_category, parent, false);
        CategoryViewHolder categoryViewHolder = new CategoryViewHolder(view);
        return categoryViewHolder;
    }

    @Override
    public void onBindViewHolder(CategoryViewHolder holder, int position) {
        Category category = Category.getList().get(position);

        holder.bind(category);
    }

    @Override
    public int getItemCount() {
        return Category.getList().size();
    }
}
