package com.example.hau.homeworkss15_tumble_log.viewholders;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

import com.example.hau.homeworkss15_tumble_log.R;
import com.example.hau.homeworkss15_tumble_log.models.Post;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by Hau on 25/10/2016.
 */
public class PostViewHolder extends RecyclerView.ViewHolder {

    @BindView(R.id.tv_title)
    TextView tvTitle;
    @BindView(R.id.tv_content)
    TextView tvContent;


    public PostViewHolder(View itemView) {
        super(itemView);
        ButterKnife.bind(this, itemView);
    }

    public void bind(Post post) {
        tvTitle.setText(post.getTitle());
        tvContent.setText(post.getContent());
    }
}
