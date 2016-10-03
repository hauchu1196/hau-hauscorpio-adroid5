package com.example.hau.session9turn4;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

/**
 * Created by Hau on 02/10/2016.
 */
public class NewAdapter extends ArrayAdapter<NewItem> {
    public NewAdapter(Context context, int resource, List<NewItem> objects) {
        super(context, resource, objects);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        LayoutInflater layoutInflater = LayoutInflater.from(this.getContext());

        convertView = layoutInflater.inflate(R.layout.list_item_new, parent, false);

        new ItemViewHolder(convertView).setData(getItem(position));


        return convertView;
    }
}
