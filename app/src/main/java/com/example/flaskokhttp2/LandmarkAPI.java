package com.example.flaskokhttp2;

import org.json.JSONObject;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.DELETE;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.PUT;
import retrofit2.http.Path;

public interface LandmarkAPI {
    /*@GET("/landmark/{names}")
    Call<Landmark> getLandmarkInfo(@Path("names") String names);*/

    @GET("/landmark/{names}")
    Call<List<Landmark>> getLandmarkInfo(@Path("names") String names);

    /*@GET("/landmark/{names}")
    Call<JSONObject> getLandmarkInfo(@Path("name") String name);*/
}
