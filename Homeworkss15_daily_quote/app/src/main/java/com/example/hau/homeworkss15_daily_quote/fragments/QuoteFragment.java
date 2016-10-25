package com.example.hau.homeworkss15_daily_quote.fragments;


import android.app.Activity;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.hau.homeworkss15_daily_quote.MainActivity;
import com.example.hau.homeworkss15_daily_quote.R;
import com.example.hau.homeworkss15_daily_quote.adapters.QuoteAdapter;
import com.example.hau.homeworkss15_daily_quote.constants.Constants;
import com.example.hau.homeworkss15_daily_quote.jsonmodels.QuoteJSONModel;
import com.example.hau.homeworkss15_daily_quote.models.Quote;
import com.google.gson.Gson;
import com.nostra13.universalimageloader.core.ImageLoader;

import java.io.IOException;

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
public class QuoteFragment extends Fragment {


    private static final String TAG = QuoteFragment.class.toString();
    @BindView(R.id.rv_quote)
    RecyclerView rvQuote;

    private QuoteAdapter quoteAdapter;

    public QuoteFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_quote, container, false);
        ButterKnife.bind(this, view);
        return view;
    }

    @Override
    public void onStart() {
        super.onStart();
        setupUI();
        sendGETRequest();
    }

    private void setupUI() {
        StaggeredGridLayoutManager layoutManager = new StaggeredGridLayoutManager(2, StaggeredGridLayoutManager.VERTICAL);
        rvQuote.setLayoutManager(layoutManager);
        quoteAdapter = new QuoteAdapter();
        rvQuote.setAdapter(quoteAdapter);
    }

    private void sendGETRequest() {

//        ImageLoader.getInstance().loadImage(Constants.UNPLASH_API, new ImageLoadingListener() {
//            @Override
//            public void onLoadingStarted(String imageUri, View view) {
//
//            }
//
//            @Override
//            public void onLoadingFailed(String imageUri, View view, FailReason failReason) {
//
//            }
//
//            @Override
//            public void onLoadingComplete(String imageUri, View view, Bitmap loadedImage) {
//                FileManager.getInstance().createImage(loadedImage, unplash);
//                Log.d(TAG, "onLoadingComplete");
//            }
//
//            @Override
//            public void onLoadingCancelled(String imageUri, View view) {
//
//            }
//        });
        // Image


        OkHttpClient client = new OkHttpClient();
        Request request = new Request.Builder().url(Constants.QUOTE_API).build();
        client.newCall(request).enqueue(new Callback() {
            @Override
            public void onFailure(Call call, IOException e) {

            }

            @Override
            public void onResponse(Call call, Response response) throws IOException {
                if (response.isSuccessful()) {
                    String bodyString = response.body().string();

                    Gson gson = new Gson();
                    QuoteJSONModel[] quotes = gson.fromJson(bodyString, QuoteJSONModel[].class);

                    for (QuoteJSONModel quoteJSONModel : quotes) {
//                        Bitmap bitmap = ImageLoader.getInstance().loadImageSync(Constants.UNPLASH_API);
                        Quote.list.add(new Quote(quoteJSONModel.getTitle(), quoteJSONModel.getContent()));
                    }
                    if (quotes.length > 0) {
                        updateQuote();
                    }
                }
            }
        });
    }

    private void updateQuote() {
        Activity parent = getActivity();
        parent.runOnUiThread(new Runnable() {
            @Override
            public void run() {
                quoteAdapter.notifyDataSetChanged();
            }
        });
    }


}
