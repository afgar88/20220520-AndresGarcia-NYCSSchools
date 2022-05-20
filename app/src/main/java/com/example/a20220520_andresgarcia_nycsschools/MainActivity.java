package com.example.a20220520_andresgarcia_nycsschools;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.example.a20220520_andresgarcia_nycsschools.databinding.ActivityMainBinding;

import dagger.hilt.android.AndroidEntryPoint;

@AndroidEntryPoint
public class MainActivity extends AppCompatActivity {

    private ActivityMainBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
    }
}