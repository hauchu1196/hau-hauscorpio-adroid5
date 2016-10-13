package com.example.hau.session12laba.fragments;


import android.app.Activity;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import com.example.hau.session12laba.MainActivity;
import com.example.hau.session12laba.R;
import com.example.hau.session12laba.constants.Constants;
import com.example.hau.session12laba.json_models.FlickrFeed;
import com.example.hau.session12laba.json_models.FlickrItem;
import com.example.hau.session12laba.views.FlickrAdapter;
import com.google.gson.Gson;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

/**
 * A simple {@link Fragment} subclass.
 */
public class FlickrFragment extends Fragment {

    private static final String TAG = FlickrFragment.class.toString();
    @BindView(R.id.lv_flickr)
    ListView lvFlickr;

    public FlickrFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_flickr, container, false);
        ButterKnife.bind(this, view);
        setupUI();
        getContent();
        return view;
    }

    private void setupUI() {
//        flickrAdapter = new FlickrAdapter(activity, R.layout.list_item_flickr, flickrItems);
//        lvFlickr.setAdapter(flickrAdapter);
    }

    private void getContent() {
        OkHttpClient client = new OkHttpClient();

        Request request = new Request.Builder().url(Constants.FLICKR_API).build();

        client.newCall(request).enqueue(new Callback() {
            @Override
            public void onFailure(Call call, IOException e) {

            }

            @Override
            public void onResponse(Call call, Response response) throws IOException {
                Log.d(TAG, "onResponse");
                String bodyString = response.body().string()
                        .replace("jsonFlickrFeed(", "")
                        .replace("})", "}");
                if (bodyString != null) {
                    Gson gson = new Gson();
                    FlickrFeed flickrFeed = gson.fromJson(bodyString, FlickrFeed.class);
                    List<FlickrItem> flickrItems = flickrFeed.getItems();
                    FlickrFragment.this.updateBody(flickrItems);
                }

            }
        });
    }

    private void updateBody(final List<FlickrItem> flickrItems) {
        Activity parent = getActivity();

        parent.runOnUiThread(new Runnable() {
            @Override
            public void run() {
                lvFlickr.setAdapter(new FlickrAdapter(
                        getContext(),
                        R.layout.list_item_flickr,
                        flickrItems
                ));
            }
        });
    }


}
