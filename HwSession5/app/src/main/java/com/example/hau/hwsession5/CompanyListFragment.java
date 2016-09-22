package com.example.hau.hwsession5;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.List;


/**
 * A simple {@link Fragment} subclass.
 */
public class CompanyListFragment extends Fragment {


    private ListView lvCompany;
    private List<Company> companyList;
    private AdapterView.OnItemClickListener tvItemListener;
    private Company company;

    public CompanyListFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_company_list, container, false);

        initData();
        getReferences(view);
        setupUI();
        addListeners();
        return view;
    }

    private void addListeners() {
        if (tvItemListener != null) {
            lvCompany.setOnItemClickListener(tvItemListener);
        }
    }


    private void initData() {
        companyList = Company.getCompanyList();
    }

    private void getReferences(View view) {
        lvCompany = (ListView) view.findViewById(R.id.lv_company);
    }

    private void setupUI() {
        ArrayAdapter<Company> companyArrayAdapter = new ArrayAdapter<Company>(getActivity().getApplicationContext(),
                android.R.layout.simple_list_item_1, companyList);
        lvCompany.setAdapter(companyArrayAdapter);
    }

    public void setTvItemListener(AdapterView.OnItemClickListener tvItemListener) {
        this.tvItemListener = tvItemListener;
    }

    public void setCompany(Company company) {
        this.company = company;
    }
}
