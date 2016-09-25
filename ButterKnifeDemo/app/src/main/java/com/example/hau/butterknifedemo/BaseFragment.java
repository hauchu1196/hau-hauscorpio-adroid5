package com.example.hau.butterknifedemo;

import android.support.v4.app.Fragment;

/**
 * Created by Hau on 25/09/2016.
 */
public class BaseFragment extends Fragment {
    protected void openFragment(Fragment fragment, boolean addToBackStack) {
        if (getActivity() instanceof FragmentChangeListener) {
            ((FragmentChangeListener) getActivity()).changeFragment(fragment, addToBackStack);
        }
    }
}
