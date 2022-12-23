package com.jmarser.tresenraya.di.module;

import android.content.Context;

import androidx.annotation.Nullable;

import com.jmarser.tresenraya.addPlayers.AddPlayersActivity;
import com.jmarser.tresenraya.selectPlayers.logic.SelectePlayersLogic;
import com.jmarser.tresenraya.selectPlayers.logic.SelectedPlayersLogicImpl;
import com.jmarser.tresenraya.selectPlayers.ui.SelectedPlayersFragment;
import com.jmarser.tresenraya.selectPlayers.ui.SelectedPlayersView;
import com.jmarser.tresenraya.singlePlayer.logic.SinglePlayerLogic;
import com.jmarser.tresenraya.singlePlayer.logic.SinglePlayerLogicImpl;
import com.jmarser.tresenraya.singlePlayer.ui.SinglePlayerFragment;
import com.jmarser.tresenraya.singlePlayer.ui.SinglePlayerView;
import com.jmarser.tresenraya.twoPlayers.logic.TwoPlayersLogic;
import com.jmarser.tresenraya.twoPlayers.logic.TwoPlayersLogicImpl;
import com.jmarser.tresenraya.twoPlayers.ui.TwoPlayersFragment;
import com.jmarser.tresenraya.twoPlayers.ui.TwoplayersView;

import dagger.Module;
import dagger.Provides;

@Module
public class AppModule {

    private Context context;
    private AddPlayersActivity addPlayersActivity;
    private SelectedPlayersFragment selectedPlayersFragment;
    private SinglePlayerFragment singlePlayerFragment;
    private TwoPlayersFragment twoPlayersFragment;

    /* CONSTRUCTORES */

    public AppModule() {
    }

    public AppModule(Context context) {
        this.context = context;
    }

    public AppModule(Context context, AddPlayersActivity addPlayersActivity) {
        this.context = context;
        this.addPlayersActivity = addPlayersActivity;
    }

    public AppModule(Context context, SelectedPlayersFragment selectedPlayersFragment) {
        this.context = context;
        this.selectedPlayersFragment = selectedPlayersFragment;
    }

    public AppModule(Context context, SinglePlayerFragment singlePlayerFragment) {
        this.context = context;
        this.singlePlayerFragment = singlePlayerFragment;
    }

    public AppModule(Context context, TwoPlayersFragment twoPlayersFragment) {
        this.context = context;
        this.twoPlayersFragment = twoPlayersFragment;
    }

    /* VISTAS */

    @Nullable
    @Provides
    public AddPlayersActivity providesAddPlayerActivity(){
        if(addPlayersActivity != null){
            return addPlayersActivity;
        }
        return null;
    }

    @Nullable
    @Provides
    public SelectedPlayersView providesSelectedPlayers(){
        if(selectedPlayersFragment != null){
            return selectedPlayersFragment;
        }
        return null;
    }

    @Nullable
    @Provides
    public SinglePlayerView providesSinglePlayer(){
        if(singlePlayerFragment != null){
            return singlePlayerFragment;
        }
        return null;
    }

    @Nullable
    @Provides
    public TwoplayersView providesTwoPlayers(){
        if(twoPlayersFragment != null){
            return twoPlayersFragment;
        }
        return null;
    }

    /* PROVEEDORES */

    @Provides
    public SelectePlayersLogic providesSelectedPlayerLogic(SelectedPlayersLogicImpl logicPresenter){
        return logicPresenter;
    }

    @Provides
    public SinglePlayerLogic providesSinglePlayerLogic(SinglePlayerLogicImpl logicPresenter){
        return logicPresenter;
    }

    @Provides
    public TwoPlayersLogic providesTwoPlayersLogic(TwoPlayersLogicImpl logicPresenter){
        return logicPresenter;
    }
}
