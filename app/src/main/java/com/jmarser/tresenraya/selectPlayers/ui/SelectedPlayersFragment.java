package com.jmarser.tresenraya.selectPlayers.ui;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.google.android.material.navigation.NavigationView;
import com.jmarser.tresenraya.R;
import com.jmarser.tresenraya.databinding.FragmentSelectedPlayersBinding;
import com.jmarser.tresenraya.di.component.AppComponent;
import com.jmarser.tresenraya.di.component.DaggerAppComponent;
import com.jmarser.tresenraya.di.module.AppModule;
import com.jmarser.tresenraya.selectPlayers.logic.SelectePlayersLogic;
import com.jmarser.tresenraya.singlePlayer.ui.SinglePlayerFragment;
import com.jmarser.tresenraya.twoPlayers.ui.TwoPlayersFragment;
import com.jmarser.tresenraya.utils.NavigationFragment;

import javax.inject.Inject;


public class SelectedPlayersFragment extends Fragment implements SelectedPlayersView, View.OnClickListener {

    private FragmentSelectedPlayersBinding binding;

    @Inject
    SelectePlayersLogic playersLogic;

    public SelectedPlayersFragment() {
        // Required empty public constructor
    }


    public static SelectedPlayersFragment newInstance() {
        SelectedPlayersFragment fragment = new SelectedPlayersFragment();

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
        binding = FragmentSelectedPlayersBinding.inflate(layoutInflater, container, false);

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

    /**
     * Inicializamos los listener
     * */
    private void initListener(){
        binding.rbSinglePlayer.setOnClickListener(this);
        binding.rbTwoPlayers.setOnClickListener(this);
        binding.btnLogoutSelected.setOnClickListener(this);
        binding.btnAddPlayersSiguiente.setOnClickListener(this);
    }

    private void checkedRadioButtons(){
        playersLogic.checkedRadioButtons(binding.rbSinglePlayer, binding.rbTwoPlayers);
    }

    @Override
    public void onClick(View view) {
        int idView = view.getId();
        if(idView == binding.btnLogoutSelected.getId()){
            getActivity().onBackPressed();
        }

        if(idView == binding.btnAddPlayersSiguiente.getId()){
            playersLogic.validateOption(binding.rbSinglePlayer, binding.rbTwoPlayers);
        }

        if(idView == binding.rbSinglePlayer.getId()){
            checkedRadioButtons();
        }

        if (idView == binding.rbTwoPlayers.getId()){
            checkedRadioButtons();
        }
    }


    @Override
    public void showInfoPlayer(int idMensajeInfo) {
        binding.tvInfoSelectPlayers.setText(idMensajeInfo);
    }

    @Override
    public void showErrorSelected(String mensaje) {
        Toast.makeText(getContext(), mensaje, Toast.LENGTH_SHORT).show();
    }

    @Override
    public void singlePlayerSelected() {
        getActivity().getSupportFragmentManager().beginTransaction()
                .setCustomAnimations(R.anim.enter_fragment_right_to_left, R.anim.exit_fragment_right_to_left, R.anim.enter_fragment_left_to_right, R.anim.exit_fragment_left_to_right)
                .replace(R.id.selected_players_frame, new SinglePlayerFragment())
                .setTransition(FragmentTransaction.TRANSIT_FRAGMENT_OPEN)
                .commit();
    }

    @Override
    public void twoPlayerSelected() {
        getActivity().getSupportFragmentManager().beginTransaction()
                .setCustomAnimations(R.anim.enter_fragment_right_to_left, R.anim.exit_fragment_right_to_left, R.anim.enter_fragment_left_to_right, R.anim.exit_fragment_left_to_right)
                .replace(R.id.selected_players_frame, new TwoPlayersFragment())
                .setTransition(FragmentTransaction.TRANSIT_FRAGMENT_OPEN)
                .commit();
    }
}