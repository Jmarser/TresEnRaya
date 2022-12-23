package com.jmarser.tresenraya.di.component;

import com.jmarser.tresenraya.addPlayers.AddPlayersActivity;
import com.jmarser.tresenraya.di.module.AppModule;
import com.jmarser.tresenraya.selectPlayers.ui.SelectedPlayersFragment;
import com.jmarser.tresenraya.singlePlayer.ui.SinglePlayerFragment;
import com.jmarser.tresenraya.twoPlayers.ui.TwoPlayersFragment;

import javax.inject.Singleton;

import dagger.Component;

@Singleton
@Component(modules = {AppModule.class})
public interface AppComponent {

    //TODO Vistas que serán inyectadas
    void inject(AddPlayersActivity addPlayersActivity);
    void inject(SelectedPlayersFragment selectedPlayersFragment);
    void inject(SinglePlayerFragment singlePlayerFragment);
    void inject(TwoPlayersFragment twoPlayersFragment);
}
