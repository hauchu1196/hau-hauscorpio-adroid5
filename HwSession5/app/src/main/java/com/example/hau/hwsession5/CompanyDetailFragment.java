package com.example.hau.hwsession5;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;


/**
 * A simple {@link Fragment} subclass.
 */
public class CompanyDetailFragment extends Fragment {

    private TextView tvName;
    private TextView tvPhone;
    private TextView tvWebsite;
    private Company company;
    private View.OnClickListener tvWebsiteListener;
    private View.OnClickListener tvPhoneListener;

    public CompanyDetailFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_company_detail, container, false);

        getReferences(view);
        setupUI();
        addListeners();

        return view;
    }

    private void getReferences(View view) {
        tvName = (TextView) view.findViewById(R.id.tv_name);
        tvPhone = (TextView) view.findViewById(R.id.tv_phone);
        tvWebsite = (TextView) view.findViewById(R.id.tv_website);
    }

    private void setupUI() {
        tvWebsite.setText(company.getWebsite());
        tvName.setText(company.getName());
        tvPhone.setText(company.getPhone());
    }

    private void addListeners() {
        if (tvWebsiteListener != null) {
            tvWebsite.setOnClickListener(tvWebsiteListener);
        }
        if (tvPhoneListener != null) {
            tvPhone.setOnClickListener(tvPhoneListener);
        }
    }

    public void setCompany(Company company) {
        this.company = company;
    }

    public void setTvWebsiteListener(View.OnClickListener tvWebsiteListener) {
        this.tvWebsiteListener = tvWebsiteListener;
    }

    public void setTvPhoneListener(View.OnClickListener tvPhoneListener) {
        this.tvPhoneListener = tvPhoneListener;
    }
}
