package com.example.hau.lab4turn1a;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.Arrays;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MainActivity extends AppCompatActivity{
    public static ListView lvItem;

    public String[] ARRAY = new String[]{
            "1",
            "2",
            "3",
            "4",
            "5"
    };
    public ArrayList<String> arrayList = new ArrayList<>(Arrays.asList(ARRAY));

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        getSupportActionBar().hide();
        lvItem = (ListView) findViewById(R.id.lv_item);
        setupUI();
        addListeners();
    }


    private void setupUI() {
        ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, arrayList);
        lvItem.setAdapter(arrayAdapter);
    }

    private void addListeners() {
        lvItem.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                FragmentManager fragmentManager = getSupportFragmentManager();
                FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
                lvItem.setEnabled(false);
                lvItem.setVisibility(View.INVISIBLE);
                Fragment curFragment = null;
                switch (position) {
                    case 0:
                        curFragment = new DetailsFragment();
                        break;
                    case 1:
                        curFragment = new InputFragment();
                        break;
                    case 2:
                        curFragment = new SettingsFragment();
                        break;
                    case 3:
                        curFragment = new SettingssFragment();
                        break;
                    case 4:
                        curFragment = new SuccessfulFragment();
                        break;
                }
                fragmentTransaction.replace(R.id.activity_main, curFragment);
                fragmentTransaction.addToBackStack(null);
                fragmentTransaction.commit();
            }
        });
    }

}
