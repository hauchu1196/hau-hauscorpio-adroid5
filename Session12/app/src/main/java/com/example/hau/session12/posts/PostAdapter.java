package com.example.hau.session12.posts;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;

import com.example.hau.session12.R;
import com.example.hau.session12.jsonmodels.PostJSONModel;

import java.util.List;

/**
 * Created by Hau on 12/10/2016.
 */
public class PostAdapter extends ArrayAdapter<PostJSONModel>{

    public PostAdapter(Context context, int resource, List<PostJSONModel> objects) {
        super(context, resource, objects);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        LayoutInflater layoutInflater = LayoutInflater.from(this.getContext());

        convertView = layoutInflater.inflate(R.layout.list_item_post, parent, false);

        new PostViewHolder(convertView).setData(getItem(position));

        return convertView;
    }
}
