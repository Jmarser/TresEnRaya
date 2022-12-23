package com.jmarser.tresenraya.twoPlayers.logic;

import com.google.android.material.textfield.TextInputLayout;

public interface TwoPlayersLogic {

    /**
     * Método con el que validamos si los campos de los nombres de los jugadores estan rellenos
     * o no, y realizamos las acciones correspondientes.
     * @param jugador1 Objeto TextInputlayout que contiene el nombre del primer jugador.
     * @param jugador2 Objeto TextInputLayout que contiene el nombre del segundo jugador.
     * */
    void validateForm(TextInputLayout jugador1, TextInputLayout jugador2);
}
