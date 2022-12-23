package com.jmarser.tresenraya.twoPlayers.logic;

import android.text.TextUtils;

import androidx.annotation.Nullable;

import com.google.android.material.textfield.TextInputLayout;
import com.jmarser.tresenraya.twoPlayers.ui.TwoplayersView;

import javax.inject.Inject;

public class TwoPlayersLogicImpl implements TwoPlayersLogic{

    @Nullable
    @Inject
    TwoplayersView twoplayersView;

    @Inject
    public TwoPlayersLogicImpl() {
    }

    @Override
    public void validateForm(TextInputLayout jugador1, TextInputLayout jugador2) {
        String nombre1 = jugador1.getEditText().getText().toString();
        String nombre2 = jugador2.getEditText().getText().toString();

        if(!TextUtils.isEmpty(nombre1)){
            if(!TextUtils.isEmpty(nombre2)){
                twoplayersView.goToGame(nombre1, nombre2);
            }else{
                twoplayersView.showErrorForm("Debe indicar el nombre del jugador");
            }
        }else{
            twoplayersView.showErrorForm("Debe indicar el nombre del jugador");
        }
    }
}
