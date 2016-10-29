package com.example.hau.hw17_bai2.viewholders;

import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

import com.example.hau.hw17_bai2.MainActivity;
import com.example.hau.hw17_bai2.R;
import com.example.hau.hw17_bai2.models.Node;


import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by Hau on 29/10/2016.
 */
public class NodeListViewHolder extends RecyclerView.ViewHolder{

    private static final String TAG = NodeListViewHolder.class.toString();
    @BindView(R.id.tv_title)
    TextView tvTitle;

    public NodeListViewHolder(View itemView) {
        super(itemView);
        ButterKnife.bind(this, itemView);
    }

    public void bind(Node node) {
        tvTitle.setText(node.getTitle());
    }


}
