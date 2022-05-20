package com.example.a20220520_andresgarcia_nycsschools.res;


import com.example.a20220520_andresgarcia_nycsschools.model.Schools;
import com.example.a20220520_andresgarcia_nycsschools.model.ScoresItem;

import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

import javax.inject.Inject;

import io.reactivex.Single;
import io.reactivex.functions.Function;

public class SchoolRepoImp implements SchoolRepo {

    private final API serviceApi;

    @Inject
    public SchoolRepoImp(API apiService) {
        serviceApi = apiService;
    }

    @Override
    public Single<List<Schools>> getSchools() {
        return serviceApi.getAllSchools();
    }

    @Override
    public Single<List<ScoresItem>> getScores(String school) {
        return serviceApi.getSchoolsScore()
                .map((Function<List<ScoresItem>, List<ScoresItem>>) scores ->
                        scores.stream().filter(scores1 ->
                                Objects.equals(scores1.getDbn(), school)).collect(Collectors.toList()));
    }
}
