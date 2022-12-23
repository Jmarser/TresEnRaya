package com.jmarser.tresenraya.addPlayers;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.jmarser.tresenraya.databinding.ActivityAddPlayersBinding;

public class AddPlayersActivity extends AppCompatActivity {

    private ActivityAddPlayersBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityAddPlayersBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
    }
}