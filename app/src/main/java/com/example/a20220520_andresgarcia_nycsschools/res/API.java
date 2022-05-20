package com.example.a20220520_andresgarcia_nycsschools.res;

import com.example.a20220520_andresgarcia_nycsschools.model.Schools;
import com.example.a20220520_andresgarcia_nycsschools.model.ScoresItem;

import java.util.List;

import io.reactivex.Single;
import retrofit2.http.GET;

public interface API {
    String BASE_URL = "https://data.cityofnewyork.us/resource/";

    @GET("s3k6-pzi2")
    Single<List<Schools>> getAllSchools();

    @GET("f9bf-2cp4")
    Single<List<ScoresItem>> getSchoolsScore();
}


