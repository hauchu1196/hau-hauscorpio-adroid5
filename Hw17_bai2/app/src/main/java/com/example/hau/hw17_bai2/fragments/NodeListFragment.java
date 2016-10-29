package com.example.hau.hw17_bai2.fragments;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;

import com.example.hau.hw17_bai2.MainActivity;
import com.example.hau.hw17_bai2.R;
import com.example.hau.hw17_bai2.adapters.NodeListAdapter;
import com.example.hau.hw17_bai2.listeners.RecyclerItemClickListener;
import com.example.hau.hw17_bai2.managers.DbHelper;
import com.example.hau.hw17_bai2.models.Node;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * A simple {@link Fragment} subclass.
 */
public class NodeListFragment extends Fragment {

    private static final String TAG = NodeListFragment.class.toString();
    public static NodeListAdapter nodeListAdapter;
    public static int pos;
    @BindView(R.id.rv_node_list)
    RecyclerView rvNodeList;

    public NodeListFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_node_list, container, false);
        ButterKnife.bind(this, view);
        setupUI();
        addListeners();
        return view;
    }

    private void addListeners() {
        rvNodeList.addOnItemTouchListener(
                new RecyclerItemClickListener(getContext(), rvNodeList, new RecyclerItemClickListener.OnItemClickListener() {
                    @Override
                    public void onItemClick(View view, int position) {
                        Log.d(TAG, String.valueOf(position));
                        pos = position;
                        ((MainActivity) getActivity()).changeFragment(new NodeDetailsFragment(), true);
                    }

                    @Override
                    public void onLongItemClick(View view, int position) {
                        DbHelper.getInstance().delete(Node.list.get(position));
                        Node.list.remove(position);
                        nodeListAdapter.notifyDataSetChanged();
                    }
                }));
    }

    private void setupUI() {
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getActivity());
        rvNodeList.setLayoutManager(linearLayoutManager);
        nodeListAdapter = new NodeListAdapter();
        rvNodeList.setAdapter(nodeListAdapter);
    }


    @OnClick(R.id.btn_add)
    public void add() {
        ((MainActivity) getActivity()).changeFragment(new AddFragment(), true);
    }

}
