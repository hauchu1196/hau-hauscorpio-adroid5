package com.example.hau.session12laba.views;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;

import com.example.hau.session12laba.R;
import com.example.hau.session12laba.json_models.FlickrItem;

import java.util.List;

/**
 * Created by Hau on 13/10/2016.
 */
public class FlickrAdapter extends ArrayAdapter<FlickrItem> {

    public FlickrAdapter(Context context, int resource, List<FlickrItem> objects) {
        super(context, resource, objects);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        LayoutInflater layoutInflater = LayoutInflater.from(this.getContext());

        convertView = layoutInflater.inflate(R.layout.list_item_flickr, parent, false);

        new FlickrItemViewHolder(convertView).setData(getItem(position));

        return convertView;
    }
}
