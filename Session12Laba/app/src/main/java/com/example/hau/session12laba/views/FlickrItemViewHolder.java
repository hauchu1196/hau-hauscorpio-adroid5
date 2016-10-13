package com.example.hau.session12laba.views;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.hau.session12laba.R;
import com.example.hau.session12laba.json_models.FlickrItem;
import com.nostra13.universalimageloader.core.ImageLoader;

import org.w3c.dom.Text;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by Hau on 13/10/2016.
 */
public class FlickrItemViewHolder {
    @BindView(R.id.tv_title_flickr)
    TextView tvTitle;
    @BindView(R.id.iv_item_flickr)
    ImageView ivItem;
    @BindView(R.id.tv_date_taken)
    TextView tvDateTaken;

    public FlickrItemViewHolder(View view) {
        ButterKnife.bind(this, view);
    }

    public void setData(FlickrItem data) {
        tvTitle.setText(data.getTitle());
        tvDateTaken.setText(data.getDateTaken());
        ImageLoader.getInstance().displayImage(data.getImageLink(), ivItem);
    }
}
