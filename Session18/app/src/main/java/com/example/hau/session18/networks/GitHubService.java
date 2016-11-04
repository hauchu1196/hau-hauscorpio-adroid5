package com.example.hau.session18.networks;

import com.example.hau.session18.jsonmodels.Repo;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Part;
import retrofit2.http.Path;

/**
 * Created by Hau on 02/11/2016.
 */
public interface GitHubService {
    @GET("users/{username}/repos")
    Call<List<Repo>> listRepo(@Path("username") String username);
}
