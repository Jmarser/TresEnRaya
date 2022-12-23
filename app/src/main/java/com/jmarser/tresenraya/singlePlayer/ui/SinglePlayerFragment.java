package com.jmarser.tresenraya.singlePlayer.ui;

import android.content.Intent;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.jmarser.tresenraya.R;
import com.jmarser.tresenraya.databinding.FragmentSinglePlayerBinding;
import com.jmarser.tresenraya.di.component.AppComponent;
import com.jmarser.tresenraya.di.component.DaggerAppComponent;
import com.jmarser.tresenraya.di.module.AppModule;
import com.jmarser.tresenraya.game.GameActivity;
import com.jmarser.tresenraya.singlePlayer.logic.SinglePlayerLogic;
import com.jmarser.tresenraya.twoPlayers.ui.TwoPlayersFragment;

import javax.inject.Inject;


public class SinglePlayerFragment extends Fragment implements View.OnClickListener, SinglePlayerView {

    private FragmentSinglePlayerBinding binding;

    @Inject
    SinglePlayerLogic singlePlayerLogic;

    public SinglePlayerFragment() {
        // Required empty public constructor
    }

    public static SinglePlayerFragment newInstance() {
        SinglePlayerFragment fragment = new SinglePlayerFragment();

        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        LayoutInflater layoutInflater = LayoutInflater.from(container.getContext());
        binding = FragmentSinglePlayerBinding.inflate(layoutInflater, container, false);

        initInjection();

        initListener();

        return binding.getRoot();
    }

    private void initInjection(){
        AppComponent appComponent = DaggerAppComponent.builder()
                .appModule(new AppModule(getContext(), this))
                .build();

        appComponent.inject(this);
    }

    private void initListener(){
        binding.btnJugar.setOnClickListener(this);
        binding.btnTwoPlayers.setOnClickListener(this);
        binding.btnLogoutSinglePlayer.setOnClickListener(this);
        binding.rbEasy.setOnClickListener(this);
        binding.rbNormal.setOnClickListener(this);
        binding.rbHard.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        int idView = view.getId();

        if(idView == binding.btnJugar.getId()){
            singlePlayerLogic.validateForm(binding.tilNomPlayer, binding.rbEasy, binding.rbNormal, binding.rbHard);
        }

        if(idView == binding.btnTwoPlayers.getId()){
            getActivity().getSupportFragmentManager().beginTransaction().replace(R.id.selected_players_frame, new TwoPlayersFragment()).commit();
        }

        if(idView == binding.btnLogoutSinglePlayer.getId()){
            getActivity().onBackPressed();
        }
    }

    @Override
    public void showErrorForm(String mensajeError) {
        Toast.makeText(getContext(), mensajeError, Toast.LENGTH_SHORT).show();
    }

    @Override
    public void goToGame(String nombreJugador, int nivelDificultad) {
        Intent intent = new Intent(getActivity(), GameActivity.class);
        startActivity(intent);
        getActivity().finish();
    }


}