package com.example.hau.session9turn4;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by Hau on 02/10/2016.
 */
public class ItemViewHolder {
    @BindView(R.id.tv_new_title)
    TextView tvNewTitle;
    @BindView(R.id.tv_new_time)
    TextView tvNewTime;
    @BindView(R.id.iv_new_item)
    ImageView ivNewTime;

    public ItemViewHolder(View view) {
        ButterKnife.bind(this, view);
    }

    public void setData(NewItem newItem) {
        tvNewTime.setText(newItem.getTime());
        tvNewTitle.setText(newItem.getTitle());
        ivNewTime.setImageResource(newItem.getImageResId());
    }
}
