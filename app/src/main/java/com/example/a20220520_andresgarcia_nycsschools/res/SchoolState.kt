package com.example.a20220520_andresgarcia_nycsschools.res

import com.example.a20220520_andresgarcia_nycsschools.model.Schools
import com.example.a20220520_andresgarcia_nycsschools.model.ScoresItem

sealed class SchoolState {
    object LOADING : SchoolState()
    data class SCHOOLS(val schools: List<Schools>) : SchoolState()
    data class SCORES(val scores: List<ScoresItem>) : SchoolState()
    data class ERROR(val error: Throwable) : SchoolState()
}
