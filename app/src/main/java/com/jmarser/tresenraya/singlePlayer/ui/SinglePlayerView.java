package com.jmarser.tresenraya.singlePlayer.ui;

public interface SinglePlayerView {

    void showErrorForm(String mensajeError);

    void goToGame(String nombreJugador, int nivelDificultad);
}
