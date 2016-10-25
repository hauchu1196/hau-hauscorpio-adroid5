package com.example.hau.homeworkss15_tumble_log.adapters;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.hau.homeworkss15_tumble_log.R;
import com.example.hau.homeworkss15_tumble_log.models.Post;
import com.example.hau.homeworkss15_tumble_log.viewholders.PostViewHolder;

/**
 * Created by Hau on 25/10/2016.
 */
public class PostAdapter extends RecyclerView.Adapter<PostViewHolder> {

    // Create new
    @Override
    public PostViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        // 1: Inflate View
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        View itemView = layoutInflater.inflate(R.layout.item_post, parent, false);

        // 2: Create View Holder
        PostViewHolder postViewHolder = new PostViewHolder(itemView);
        return postViewHolder;
    }

    @Override
    public void onBindViewHolder(PostViewHolder holder, int position) {
        Post post = Post.list.get(position);

        holder.bind(post);
    }

    @Override
    public int getItemCount() {
        return Post.list.size();
    }
}
