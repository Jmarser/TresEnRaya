package com.jmarser.tresenraya.singlePlayer.logic;

import android.text.TextUtils;
import android.widget.RadioButton;

import com.google.android.material.textfield.TextInputLayout;
import com.jmarser.tresenraya.singlePlayer.ui.SinglePlayerView;

import org.jetbrains.annotations.Nullable;

import javax.inject.Inject;

public class SinglePlayerLogicImpl implements SinglePlayerLogic{

    @Nullable
    @Inject
    SinglePlayerView singlePlayerView;

    @Inject
    public SinglePlayerLogicImpl() {
    }

    @Override
    public void validateForm(TextInputLayout nomJugador, RadioButton opcion1, RadioButton opcion2, RadioButton opcion3) {
        String nombre = nomJugador.getEditText().getText().toString();
        if(!TextUtils.isEmpty(nombre)){
            if(opcion1.isChecked() || opcion2.isChecked() || opcion3.isChecked()){
                int dificultad = -1;
                if(opcion1.isChecked()){
                    dificultad = 0;
                }
                if (opcion2.isChecked()){
                    dificultad = 1;
                }
                if(opcion3.isChecked()){
                    dificultad = 3;
                }

                if(dificultad != -1) {
                    singlePlayerView.goToGame(nombre, dificultad);
                }
            }else{
                singlePlayerView.showErrorForm("Seleccione un nivel de dificultad.");
            }
        }else{
            singlePlayerView.showErrorForm("Debe indicar un nombre de jugador.");
        }
    }
}
