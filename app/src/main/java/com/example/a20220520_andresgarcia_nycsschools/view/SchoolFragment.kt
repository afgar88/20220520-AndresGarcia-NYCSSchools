package com.example.a20220520_andresgarcia_nycsschools.view

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import com.example.a20220520_andresgarcia_nycsschools.adapter.SchoolAdapter
import com.example.a20220520_andresgarcia_nycsschools.databinding.FragmentSchoolBinding
import com.example.a20220520_andresgarcia_nycsschools.res.SchoolState
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.a20220520_andresgarcia_nycsschools.R

class SchoolFragment : BaseFragment() {

    private val binding by lazy {
        FragmentSchoolBinding.inflate(layoutInflater)
    }

    private val schoolAdapter by lazy {
        SchoolAdapter() {
            var data = it.dbn.toString()

            // viewModelSchool.dbnSchool = it.dbn.toString()
            var intention = SchoolFragmentDirections.actionSchoolFragmentToScoreFragment(data)
            findNavController().navigate(intention)
            //   findNavController().navigate(R.id.action_schoolFragment_to_scoreFragment)
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment

        binding.rvSchool.apply {
            layoutManager =
                LinearLayoutManager(requireContext(), LinearLayoutManager.VERTICAL, false)
            adapter = schoolAdapter
        }

        viewModelSchool.schools.observe(viewLifecycleOwner) {
            when (it) {
                is SchoolState.LOADING -> {
                    Toast.makeText(activity, "Loading...", Toast.LENGTH_SHORT)
                        .show()
                }
                is SchoolState.SCHOOLS -> {
                    Log.d("SUCCESS1", it.schools.first().dbn.toString())
                    it.schools.let {
                        schoolAdapter.update(it)

                    }
                }
                is SchoolState.ERROR -> {
                    Toast.makeText(requireContext(), it.error.localizedMessage, Toast.LENGTH_LONG)
                        .show()
                }
            }
        }

        viewModelSchool.getAllSchools()

        return binding.root
    }
}