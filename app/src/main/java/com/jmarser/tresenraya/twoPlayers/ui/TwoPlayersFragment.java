package com.jmarser.tresenraya.twoPlayers.ui;

import android.content.Intent;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.jmarser.tresenraya.R;
import com.jmarser.tresenraya.databinding.FragmentTwoPlayersBinding;
import com.jmarser.tresenraya.di.component.AppComponent;
import com.jmarser.tresenraya.di.component.DaggerAppComponent;
import com.jmarser.tresenraya.di.module.AppModule;
import com.jmarser.tresenraya.game.GameActivity;
import com.jmarser.tresenraya.singlePlayer.ui.SinglePlayerFragment;
import com.jmarser.tresenraya.twoPlayers.logic.TwoPlayersLogic;
import com.jmarser.tresenraya.utils.NavigationFragment;

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

        //Boton salir del juego
        if(idView == binding.btnLogoutTwoPlayers.getId()){
            getActivity().onBackPressed();
        }

        //Botón mostrar info del fragment
        if(idView == binding.btnInfoTwoPlayers.getId()){

        }

        //Botón para cambiar al fragment singleplayer
        if(idView == binding.btnSinglePlayer.getId()){
            getActivity().getSupportFragmentManager().beginTransaction()
                    .setCustomAnimations(R.anim.enter_fragment_left_to_right, R.anim.exit_fragment_left_to_right, R.anim.enter_fragment_right_to_left, R.anim.exit_fragment_right_to_left)
                    .replace(R.id.selected_players_frame, new SinglePlayerFragment())
                    .setTransition(FragmentTransaction.TRANSIT_FRAGMENT_FADE)
                    .commit();
        }

        //Botón para jugar
        if(idView == binding.btnJugarTwoPlayers.getId()){
            playersLogic.validateForm(binding.nomPlayerSingle, binding.nomPlayerTwo);
        }
    }

    @Override
    public void showErrorForm(String mensajeError) {
        Toast.makeText(getContext(), mensajeError, Toast.LENGTH_SHORT).show();
    }

    @Override
    public void goToGame(String nombreJugador1, String nombreJugador2) {
        Intent intent = new Intent(getActivity(), GameActivity.class);
        startActivity(intent);
    }
}