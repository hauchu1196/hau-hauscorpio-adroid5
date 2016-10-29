package com.example.hau.hw17_bai2;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

import com.example.hau.hw17_bai2.fragments.NodeListFragment;
import com.example.hau.hw17_bai2.managers.DbHelper;
import com.example.hau.hw17_bai2.models.Node;

public class MainActivity extends AppCompatActivity {

    private static final String TAG = MainActivity.class.toString();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        loadDataFromDatabase();
        Log.d(TAG, String.valueOf(Node.list.size()));
        changeFragment(new NodeListFragment(), false);
    }

    private void loadDataFromDatabase() {
        Node.list = DbHelper.getInstance().selectAllNode();
    }

    public void changeFragment(Fragment fragment, boolean addToBackStack) {
        FragmentTransaction fragmentTransaction = getSupportFragmentManager()
                .beginTransaction()
                .replace(R.id.fl_container, fragment);
        if (addToBackStack) {
            fragmentTransaction.addToBackStack(null);
        }
        fragmentTransaction.commit();
    }
}
