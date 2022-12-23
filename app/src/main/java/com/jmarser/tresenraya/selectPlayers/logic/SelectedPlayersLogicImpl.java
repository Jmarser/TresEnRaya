package com.jmarser.tresenraya.selectPlayers.logic;

import android.widget.RadioButton;
import com.jmarser.tresenraya.R;
import com.jmarser.tresenraya.selectPlayers.ui.SelectedPlayersView;
import org.jetbrains.annotations.Nullable;
import javax.inject.Inject;

public class SelectedPlayersLogicImpl implements SelectePlayersLogic{

    @Nullable
    @Inject
    SelectedPlayersView playersView;

    @Inject
    public SelectedPlayersLogicImpl() {
    }

    @Override
    public void checkedRadioButtons(RadioButton opcion1, RadioButton opcion2) {
        if (opcion1.isChecked()){
            playersView.showInfoPlayer(R.string.info_single_player);
        }
        if (opcion2.isChecked()){
            playersView.showInfoPlayer(R.string.info_two_players);
        }
    }

    @Override
    public void validateOption(RadioButton opcion1, RadioButton opcion2) {
        if (opcion1.isChecked() || opcion2.isChecked()){
            if(opcion1.isChecked()){
                playersView.singlePlayerSelected();
            }
            if (opcion2.isChecked()){
                playersView.twoPlayerSelected();
            }
        }else{
            playersView.showErrorSelected("Debe seleccionar una opción");
        }
    }
}
