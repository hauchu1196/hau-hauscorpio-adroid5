package com.example.hau.hw17_bai2.fragments;


import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.TextView;

import com.example.hau.hw17_bai2.R;
import com.example.hau.hw17_bai2.managers.DbHelper;
import com.example.hau.hw17_bai2.models.Node;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * A simple {@link Fragment} subclass.
 */
public class NodeDetailsFragment extends Fragment {

    private int position;
    @BindView(R.id.et_title)
    EditText etTitle;
    @BindView(R.id.et_content)
    EditText etContent;
    @BindView(R.id.tv_date)
    TextView tvDate;

    public NodeDetailsFragment() {
        // Required empty public constructor
    }


    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        position = NodeListFragment.pos;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_node_details, container, false);
        ButterKnife.bind(this, view);
        setupUI();
        return view;
    }

    private void setupUI() {
        Node node = Node.list.get(position);
        etTitle.setText(node.getTitle());
        etContent.setText(node.getContent());
        tvDate.setText(node.getTimeCreated());
    }

    public static NodeListFragment newInstance(int position) {
        NodeListFragment nodeListFragment = new NodeListFragment();
        Bundle bundle = new Bundle();
        bundle.putInt("position", position);
        nodeListFragment.setArguments(bundle);
        return nodeListFragment;
    }

    @OnClick(R.id.btn_save)
    public void save() {
        Node node = Node.list.get(position);
        node.setTitle(etTitle.getText().toString());
        node.setContent(etContent.getText().toString());
        DbHelper.getInstance().update(node);
        getActivity().onBackPressed();
    }

}
