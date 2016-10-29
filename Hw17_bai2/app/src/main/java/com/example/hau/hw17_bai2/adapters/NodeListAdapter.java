package com.example.hau.hw17_bai2.adapters;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.hau.hw17_bai2.R;
import com.example.hau.hw17_bai2.models.Node;
import com.example.hau.hw17_bai2.viewholders.NodeListViewHolder;

/**
 * Created by Hau on 29/10/2016.
 */
public class NodeListAdapter extends RecyclerView.Adapter<NodeListViewHolder> {

    @Override
    public NodeListViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        View view = layoutInflater.inflate(R.layout.item_node, parent, false);
        NodeListViewHolder nodeListViewHolder = new NodeListViewHolder(view);
        return nodeListViewHolder;
    }

    @Override
    public void onBindViewHolder(NodeListViewHolder holder, int position) {
        Node node = Node.list.get(position);
        holder.bind(node);
    }

    @Override
    public int getItemCount() {
        return Node.list.size();
    }


}
