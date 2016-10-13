package com.example.hau.session12.fragments;


import android.app.Activity;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import com.example.hau.session12.jsonmodels.FlickrJSONModel;
import com.example.hau.session12.posts.PostAdapter;
import com.example.hau.session12.R;
import com.example.hau.session12.constants.Constants;
import com.example.hau.session12.jsonmodels.PostJSONModel;
import com.google.gson.Gson;

import java.io.IOException;
import java.util.Arrays;

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
public class PostFragment extends Fragment {

    private static final String TAG = PostFragment.class.toString();
    @BindView(R.id.lv_post)
    ListView lvPost;

    public PostFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_post, container, false);
        ButterKnife.bind(this, view);
        setupUI();
        return view;
    }

    private void updatePost(final PostJSONModel[] posts) {
        Activity parent = getActivity();

        parent.runOnUiThread(new Runnable() {
            @Override
            public void run() {
                lvPost.setAdapter(new PostAdapter(PostFragment.this.getActivity() , R.layout.list_item_post, Arrays.asList(posts)));
            }
        });
    }

    private void setupUI() {
        OkHttpClient client = new OkHttpClient();

        Request request = new Request.Builder().url(Constants.PLACE_HOLDER_API).build();

        client.newCall(request).enqueue(new Callback() {
            @Override
            public void onFailure(Call call, IOException e) {
                Log.d(TAG, "onFailure");
            }

            @Override
            public void onResponse(Call call, Response response) throws IOException {
                Log.d(TAG, "onResponse");
                String bodyString = response.body().string();

                Gson gson = new Gson();

                PostJSONModel[] posts = gson.fromJson(bodyString, PostJSONModel[].class);

                if (posts.length > 0) {
                    PostFragment.this.updatePost(posts);
                }

            }
        });

//        Request request = new Request.Builder().url(Constants.FLICKR_API).build();
//        client.newCall(request).enqueue(new Callback() {
//            @Override
//            public void onFailure(Call call, IOException e) {
//
//            }
//
//            @Override
//            public void onResponse(Call call, Response response) throws IOException {
//                Log.d(TAG, "onResponse");
//                String bodyString = response.body().string();
//                Gson gson = new Gson();
//                FlickrJSONModel flickrJSONModel = gson.fromJson(bodyString, FlickrJSONModel.class);
//            }
//        });
//    }
    }
}
