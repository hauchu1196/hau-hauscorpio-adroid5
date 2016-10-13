package com.example.hau.session12.posts;

import android.view.View;
import android.widget.TextView;


import com.example.hau.session12.R;
import com.example.hau.session12.jsonmodels.PostJSONModel;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by Hau on 12/10/2016.
 */
public class PostViewHolder {
    @BindView(R.id.tv_title)
    TextView tvTitle;
    @BindView(R.id.tv_body)
    TextView tvBody;
    @BindView(R.id.tv_user_id)
    TextView tvUserId;

    public PostViewHolder(View view) {
        ButterKnife.bind(this, view);
    }

    public void setData(PostJSONModel postJSONModel) {
        tvBody.setText(postJSONModel.getBody());
        tvTitle.setText(postJSONModel.getTitle());
        tvUserId.setText(postJSONModel.getUserId());
    }
}
