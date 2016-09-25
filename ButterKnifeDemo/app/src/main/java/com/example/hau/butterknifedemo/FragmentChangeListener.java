package com.example.hau.butterknifedemo;

import android.support.v4.app.Fragment;

/**
 * Created by Hau on 25/09/2016.
 */
public interface FragmentChangeListener {
    void changeFragment(Fragment fragment, boolean addToBackStack);
}
