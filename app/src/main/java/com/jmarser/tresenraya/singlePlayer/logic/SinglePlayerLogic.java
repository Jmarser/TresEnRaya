package com.jmarser.tresenraya.singlePlayer.logic;

import android.widget.RadioButton;

import com.google.android.material.textfield.TextInputLayout;

public interface SinglePlayerLogic {

    /**
     * Método que se encarga de validar si el campo del nombre de usuario se encuentra relleno y si
     * alguna de las opciones de dificultad se encuentra marcada.
     * @param nomJugador TextInputLayout -> objeto que nos proporciona el nombre del jugador.
     * @param opcion1 RadioButton -> opción a seleccionar.
     * @param opcion2 RadioButton -> opción a seleccionar.
     * @param opcion3 RadioButton -> opción a seleccionar.
     * */
    void validateForm(TextInputLayout nomJugador, RadioButton opcion1, RadioButton opcion2, RadioButton opcion3);
}
