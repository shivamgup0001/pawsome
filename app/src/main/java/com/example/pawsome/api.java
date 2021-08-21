package com.example.pawsome;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.Headers;

public interface api {

    @Headers({

            "x-api-key: 7fd6111c-6b1f-4fd6-b220-a5acb514a29a"
    })
    @GET("breeds")
    Call<List<data>> getData();

}
