package com.example.hau.hwsession5;

import android.content.Intent;
import android.net.Uri;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Adapter;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.List;

public class CompanyListActivity extends AppCompatActivity implements View.OnClickListener, AdapterView.OnItemClickListener {

    private Company company;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_company_list);
        initData();
        getReferences();
        setupUI();
        addListeners();
        openListFragment();
    }

    private void openListFragment() {
        // fragment list
        CompanyListFragment companyListFragment = new CompanyListFragment();
        companyListFragment.setCompany(company);
        companyListFragment.setTvItemListener(this);

        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.replace(R.id.fl_container, companyListFragment);
        fragmentTransaction.addToBackStack(null);
        fragmentTransaction.commit();
    }

    private void initData() {
    }

    private void getReferences() {
    }

    private void setupUI() {
    }

    private void addListeners() {

    }

    @Override
    public void onClick(View v) {
        if (v.getId() == R.id.tv_website) {
            String googleSearch = String.format("https://google.com/search?q=%s", company.getWebsite());
            Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse(googleSearch));
            startActivity(intent);
        } else if (v.getId() == R.id.tv_phone) {
            String phone = company.getPhone();
            Intent intent = new Intent(Intent.ACTION_CALL);
            intent.setData(Uri.parse("tel:" + phone));
            startActivity(intent);
        }
    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        company = Company.getCompanyList().get(position);

        CompanyDetailFragment companyDetailFragment = new CompanyDetailFragment();
        companyDetailFragment.setCompany(company);
        companyDetailFragment.setTvWebsiteListener(this);
        companyDetailFragment.setTvPhoneListener(this);

        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.replace(R.id.fl_container, companyDetailFragment);
        fragmentTransaction.addToBackStack(null);
        fragmentTransaction.commit();
    }
}
