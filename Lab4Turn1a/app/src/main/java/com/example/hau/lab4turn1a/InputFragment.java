package com.example.hau.lab4turn1a;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;


/**
 * A simple {@link Fragment} subclass.
 */
public class InputFragment extends Fragment {

    private ImageView ivBack;

    public InputFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_input, container, false);
        addListeners(view);
        return view;
    }

    private void addListeners(View view) {
        ivBack = (ImageView) view.findViewById(R.id.iv_back);
        ivBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getFragmentManager().popBackStack();
                MainActivity.lvItem.setEnabled(true);
                MainActivity.lvItem.setVisibility(View.VISIBLE);

            }
        });
    }

    @Override
    public void onStop() {
        MainActivity.lvItem.setEnabled(true);
        MainActivity.lvItem.setVisibility(View.VISIBLE);
        super.onStop();
    }
}
