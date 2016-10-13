package com.example.hau.session12.flickrs;

import android.content.Context;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.hau.session12.R;
import com.example.hau.session12.jsonmodels.FlickrJSONModel;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by Hau on 12/10/2016.
 */
public class FlickrViewHolder {
    @BindView(R.id.tv_title_flickr)
    TextView tvTitleFlickr;
    @BindView(R.id.iv_flickr)
    ImageView ivFlickr;

    public FlickrViewHolder (View view) {
        ButterKnife.bind(this, view);
    }

//    public void setData(FlickrJSONModel flickrJSONModel) {
//        tvTitleFlickr.setText(flickrJSONModel.getTitle());
//
//    }
}
