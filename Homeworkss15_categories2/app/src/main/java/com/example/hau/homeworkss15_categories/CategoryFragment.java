package com.example.hau.homeworkss15_categories;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.hau.homeworkss15_categories.adapters.CategoryAdapter;
import com.example.hau.homeworkss15_categories.models.Category;

import java.util.Collections;
import java.util.Comparator;

import butterknife.BindView;
import butterknife.ButterKnife;


/**
 * A simple {@link Fragment} subclass.
 */
public class CategoryFragment extends Fragment {


    public static RecyclerView rvCategories;
    private CategoryAdapter categoryAdapter;
    public CategoryFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_categori, container, false);
        rvCategories = (RecyclerView) view.findViewById(R.id.rv_categories);
        setupUI();
        return view;
    }

    private void setupUI() {
        LinearLayoutManager layoutManager = new LinearLayoutManager(getContext());
        rvCategories.setLayoutManager(layoutManager);
        Collections.sort(Category.getList(), new Comparator<Category>() {
            @Override
            public int compare(Category o1, Category o2) {
                return o1.getTitle().compareTo(o2.getTitle());
            }
        });
        categoryAdapter = new CategoryAdapter();
        rvCategories.setAdapter(categoryAdapter);

    }

}
