package com.jmarser.tresenraya.selectPlayers.ui;

public interface SelectedPlayersView {

    void showInfoPlayer(int idMensajeInfo);

    void showErrorSelected(String mensaje);

    void singlePlayerSelected();

    void twoPlayerSelected();
}
