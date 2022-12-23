package com.jmarser.tresenraya.twoPlayers.ui;

public interface TwoplayersView {

    /**
     * Método que se encargará de mostrar los posibles errores del formulario.
     * @param mensajeError Mensaje que se mostrará al usuario.
     * */
    void showErrorForm(String mensajeError);

    /**
     * Método que se encargá de gestionar el paso a la actividad de juego, pasandole los datos
     * necesarios a la actividad.
     * @param nombreJugador1 String; nombre del primer jugador.
     * @param nombreJugador2 String; nombre del segundo jugador.
     * */
    void goToGame(String nombreJugador1, String nombreJugador2);
}
