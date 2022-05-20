package com.example.a20220520_andresgarcia_nycsschools.res;

import com.example.a20220520_andresgarcia_nycsschools.model.Schools;
import com.example.a20220520_andresgarcia_nycsschools.model.ScoresItem;

import java.util.List;

import io.reactivex.Single;

public interface SchoolRepo {
    Single<List<Schools>> getSchools();
    Single<List<ScoresItem>> getScores(String schoolDbn);
}
