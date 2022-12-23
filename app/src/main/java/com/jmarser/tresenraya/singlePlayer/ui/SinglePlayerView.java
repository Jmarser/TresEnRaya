package com.jmarser.tresenraya.singlePlayer.ui;

public interface SinglePlayerView {

    /**
     * Método que se encargará de mostrar los posibles errores que se produzcan al rellenar el
     * formulario.
     * @param mensajeError String -> mensaje que se mostrará al usuario.
     * */
    void showErrorForm(String mensajeError);

    /**
     * Método que gestionará el paso a la actividad de juego, pasándole los datos necesarios.
     * @param nombreJugador String -> nombre del jugador.
     * @param nivelDificultad int -> nivel de dificultad que usará la IA.
     * */
    void goToGame(String nombreJugador, int nivelDificultad);
}
