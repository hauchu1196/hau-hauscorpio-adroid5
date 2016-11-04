package com.example.hau.session18;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

import com.example.hau.session18.jsonmodels.Repo;
import com.example.hau.session18.managers.DbContext;
import com.example.hau.session18.models.Dog;
import com.example.hau.session18.models.Person;
import com.example.hau.session18.networks.GitHubService;

import java.util.List;

import io.realm.Case;
import io.realm.Realm;
import io.realm.RealmModel;
import io.realm.RealmResults;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.GsonConverterFactory;
import retrofit2.Response;
import retrofit2.Retrofit;

public class MainActivity extends AppCompatActivity {

    private static final String TAG = MainActivity.class.toString();

    private DbContext dbContext;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
//
//        DbContext.init(this);
//
//        dbContext = DbContext.getInstance();
//
//
//        int personId = dbContext.getNextId(Person.class, "id");
//
//
//
//        Log.d(TAG, "=============================");
//        for (Person person : dbContext.findAllPerson()) {
//            Log.d(TAG, person.toString());
//        }

        Retrofit retrofit = new Retrofit
                .Builder()
                .baseUrl("https://api.github.com/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        GitHubService gitHubService = retrofit.create(GitHubService.class);

        gitHubService
                .listRepo("hauchu1196")
                .enqueue(new Callback<List<Repo>>() {
                    @Override
                    public void onResponse(Call<List<Repo>> call, Response<List<Repo>> response) {
                        Log.d(TAG, "onResponse");
                        List<Repo> repoList = response.body();
                        for (Repo repo : repoList) {
                            Log.d(TAG, repo.toString());
                        }
                    }

                    @Override
                    public void onFailure(Call<List<Repo>> call, Throwable t) {
                        Log.d(TAG, "onFailure");
                    }
                });


    }
}
