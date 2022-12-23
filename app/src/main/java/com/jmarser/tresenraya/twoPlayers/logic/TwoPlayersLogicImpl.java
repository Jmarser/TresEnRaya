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
        //obtenemos los textos de los campos
        String nombre1 = jugador1.getEditText().getText().toString();
        String nombre2 = jugador2.getEditText().getText().toString();

        if(!TextUtils.isEmpty(nombre1)){//Campo no vacio
            if(!TextUtils.isEmpty(nombre2)){ //campo no vacío.
                twoplayersView.goToGame(nombre1, nombre2);

            }else{ //Campo vacío.
                twoplayersView.showErrorForm("Debe indicar el nombre del jugador");
                jugador2.getEditText().setError("Falta el nombre del jugador");
                jugador2.getEditText().findFocus();
            }
        }else{ //Campo vacío.
            twoplayersView.showErrorForm("Debe indicar el nombre del jugador");
            jugador1.getEditText().setError("Falta nombre del jugador.");
            jugador1.getEditText().findFocus();
        }
    }
}
