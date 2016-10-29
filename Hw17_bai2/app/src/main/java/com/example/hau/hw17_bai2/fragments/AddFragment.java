package com.example.hau.hw17_bai2.fragments;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.TextView;

import com.example.hau.hw17_bai2.R;
import com.example.hau.hw17_bai2.managers.DbHelper;
import com.example.hau.hw17_bai2.models.Node;

import java.text.SimpleDateFormat;
import java.util.Date;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * A simple {@link Fragment} subclass.
 */
public class AddFragment extends Fragment {

    @BindView(R.id.et_content_add)
    EditText etContent;
    @BindView(R.id.et_title_add)
    EditText etTitle;
    @BindView(R.id.tv_date_add)
    TextView tvDate;

    public AddFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_add, container, false);
        ButterKnife.bind(this, view);
        setupUI();
        return view;
    }

    private void setupUI() {
        Date date = new Date();
        SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy");
        tvDate.setText(format.format(date));
    }

    @OnClick(R.id.btn_add_add)
    public void addNode() {
        Node node = new Node(etTitle.getText().toString(), etContent.getText().toString(), tvDate.getText().toString());
        DbHelper.getInstance().insert(node);
        Node.list.add(node);
        NodeListFragment.nodeListAdapter.notifyDataSetChanged();
        getActivity().onBackPressed();
    }
}
