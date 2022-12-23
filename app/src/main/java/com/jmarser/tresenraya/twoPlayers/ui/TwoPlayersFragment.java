package com.jmarser.tresenraya.twoPlayers.ui;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.jmarser.tresenraya.R;
import com.jmarser.tresenraya.databinding.FragmentTwoPlayersBinding;
import com.jmarser.tresenraya.di.component.AppComponent;
import com.jmarser.tresenraya.di.component.DaggerAppComponent;
import com.jmarser.tresenraya.di.module.AppModule;
import com.jmarser.tresenraya.twoPlayers.logic.TwoPlayersLogic;

import javax.inject.Inject;

public class TwoPlayersFragment extends Fragment implements View.OnClickListener, TwoplayersView {

    private FragmentTwoPlayersBinding binding;

    @Inject
    TwoPlayersLogic playersLogic;

    public TwoPlayersFragment() {
        // Required empty public constructor
    }

    public static TwoPlayersFragment newInstance() {
        TwoPlayersFragment fragment = new TwoPlayersFragment();

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
        binding = FragmentTwoPlayersBinding.inflate(layoutInflater, container, false);

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
        binding.btnLogoutTwoPlayers.setOnClickListener(this);
        binding.btnInfoTwoPlayers.setOnClickListener(this);
        binding.btnJugarTwoPlayers.setOnClickListener(this);
        binding.btnSinglePlayer.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        int idView = view.getId();

        if(idView == binding.btnLogoutTwoPlayers.getId()){

        }

        if(idView == binding.btnInfoTwoPlayers.getId()){

        }

        if(idView == binding.btnSinglePlayer.getId()){

        }

        if(idView == binding.btnJugarTwoPlayers.getId()){

        }
    }

    @Override
    public void showErrorForm(String mensajeError) {

    }

    @Override
    public void goToGame(String nombreJugador1, String nombreJugador2) {

    }
}