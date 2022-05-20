package com.example.a20220520_andresgarcia_nycsschools.view

import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.example.a20220520_andresgarcia_nycsschools.viewmodel.SchoolsViewModel
import dagger.hilt.android.AndroidEntryPoint


@AndroidEntryPoint
open class BaseFragment : Fragment(){
    protected val viewModelSchool: SchoolsViewModel by lazy {
        ViewModelProvider(requireActivity())[SchoolsViewModel::class.java]
    }
}