package com.example.hau.homeworkss15_tumble_log;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;

import com.example.hau.homeworkss15_tumble_log.adapters.PostAdapter;
import com.example.hau.homeworkss15_tumble_log.constants.Constant;
import com.example.hau.homeworkss15_tumble_log.jsonmodels.PostJSONModel;
import com.example.hau.homeworkss15_tumble_log.models.Post;
import com.google.gson.Gson;

import java.io.IOException;

import butterknife.BindView;
import butterknife.ButterKnife;
import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

public class MainActivity extends AppCompatActivity {

    private PostAdapter postAdapter;
    @BindView(R.id.rv_post)
    RecyclerView rvPost;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        setupUI();
        sendGETRequest();
    }


    private void setupUI() {
//        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        StaggeredGridLayoutManager layoutManager = new StaggeredGridLayoutManager(2, StaggeredGridLayoutManager.VERTICAL);
        rvPost.setLayoutManager(layoutManager);

        postAdapter = new PostAdapter();
        rvPost.setAdapter(postAdapter);
    }

    private void sendGETRequest() {
        OkHttpClient client = new OkHttpClient();
        Request request = new Request.Builder().url(Constant.TUMBLELOG_API).build();
        client.newCall(request).enqueue(new Callback() {
            @Override
            public void onFailure(Call call, IOException e) {

            }

            @Override
            public void onResponse(Call call, Response response) throws IOException {
                if (response.isSuccessful()) {
                    String bodyString = response.body().string();
                    Gson gson = new Gson();
                    PostJSONModel[] postJSONModels = gson.fromJson(bodyString, PostJSONModel[].class);
                    Post.list.clear();
                    for (PostJSONModel postJSONModel : postJSONModels) {
                        Post.list.add(new Post(postJSONModel.getTitle(), postJSONModel.getContent()));
                    }

                    MainActivity.this.runOnUiThread(new Runnable() {
                        @Override
                        public void run() {
                            postAdapter.notifyDataSetChanged();
                        }
                    });
                }
            }
        });
    }
}
