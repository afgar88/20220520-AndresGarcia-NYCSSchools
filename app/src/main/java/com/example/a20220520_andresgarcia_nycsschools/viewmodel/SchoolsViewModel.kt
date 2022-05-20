package com.example.a20220520_andresgarcia_nycsschools.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.a20220520_andresgarcia_nycsschools.res.SchoolRepo
import com.example.a20220520_andresgarcia_nycsschools.res.SchoolState
import dagger.hilt.android.lifecycle.HiltViewModel
import io.reactivex.Scheduler
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import javax.inject.Inject


/**
I use the MVVM architecture pattern because its advantages,
life cycle aware with the liveData and i can share the data to all views just with one view model
also i use XRJava to avoid the ANR
 */

@HiltViewModel
class SchoolsViewModel @Inject constructor(
    private val repository: SchoolRepo,
    private val ioScheduler: Scheduler,
    private val disposables: CompositeDisposable
) : ViewModel() {

    var dbnSchool: String = ""

    private val _schools: MutableLiveData<SchoolState> = MutableLiveData(SchoolState.LOADING)
    val schools: LiveData<SchoolState> get() = _schools

    private val _scores: MutableLiveData<SchoolState> = MutableLiveData(SchoolState.LOADING)
    val scores: LiveData<SchoolState> get() = _scores

    fun getAllSchools() {
        repository.schools
            .subscribeOn(ioScheduler)
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe(
                { _schools.postValue(SchoolState.SCHOOLS(it)) },
                { _schools.postValue(SchoolState.ERROR(it)) }
            ).also { disposables.add(it) }
    }

    fun getScoreByDbn(schoolDbn: String) {
        repository.getScores(schoolDbn)
            .subscribeOn(ioScheduler)
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe(
                { _scores.postValue(SchoolState.SCORES(it)) },
                { _scores.postValue(SchoolState.ERROR(it)) }
            ).also { disposables.add(it) }
    }

    override fun onCleared() {
        super.onCleared()
        disposables.dispose()
    }
}